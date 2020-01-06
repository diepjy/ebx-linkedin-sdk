/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.echobox.api.linkedin.connection.v2;

import com.echobox.api.linkedin.client.BinaryAttachment;
import com.echobox.api.linkedin.client.DefaultWebRequestor;
import com.echobox.api.linkedin.client.LinkedInClient;
import com.echobox.api.linkedin.client.Parameter;
import com.echobox.api.linkedin.client.WebRequestor;
import com.echobox.api.linkedin.exception.LinkedInException;
import com.echobox.api.linkedin.exception.LinkedInNetworkException;
import com.echobox.api.linkedin.exception.LinkedInOAuthException;
import com.echobox.api.linkedin.types.assets.CheckStatusUpload;
import com.echobox.api.linkedin.types.assets.CompleteMultiPartUploadBody;
import com.echobox.api.linkedin.types.assets.RegisterUpload;
import com.echobox.api.linkedin.types.assets.RegisterUploadRequestBody;
import com.echobox.api.linkedin.types.assets.RelationshipType;
import com.echobox.api.linkedin.types.urn.URN;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Assets connection
 * Find the process to upload an asset to Linked in at:
 * @see <a href="https://docs.microsoft.com/en-us/linkedin/marketing/integrations/community-management/shares/vector-asset-api">
 * Assets API</a>
 * @author Joanna
 */
public class AssetsConnection extends ConnectionBaseV2 {
  
  private static final String ASSETS = "/assets";
  private static final String ACTION_KEY = "action";
  private static final String REGISTER_UPLOAD = "registerUpload";
  private static final String COMPLETE_MULTIPART_UPLOAD = "completeMultiPartUpload";
  private static final String USER_GENERATED_CONTENT_IDENTIFIER = "urn:li:userGeneratedContent";
  
  /**
   * Initialise the assets connection
   * @param linkedInClient the LinkedIn client
   */
  public AssetsConnection(LinkedInClient linkedInClient) {
    super(linkedInClient);
  }
  
  public URN uploadImageAsset(URN organizationURN, String filename, File file) throws IOException {
    validateOrganizationURN(organizationURN);
    RegisterUpload registerUploadResponse = registerUploadForImageAssets(organizationURN);
  
    // Upload the image
    AssetsConnection.uploadAsset(linkedinClient.getWebRequestor(),
        new URL(registerUploadResponse.getValue().getUploadMechanism().getMediaUploadHttpRequest()
            .getUploadUrl()), new HashMap<>(), filename, file);
    
    return registerUploadResponse.getValue().getAsset();
  }
  
  private RegisterUpload registerUploadForImageAssets(URN organizationURN) {
    // Register the upload
    RegisterUploadRequestBody.ServiceRelationships serviceRelationships =
        new RegisterUploadRequestBody.ServiceRelationships(USER_GENERATED_CONTENT_IDENTIFIER,
            RelationshipType.OWNER);
    RegisterUploadRequestBody.RegisterUploadRequest registerUploadRequest =
        new RegisterUploadRequestBody.RegisterUploadRequest(organizationURN);
    registerUploadRequest.setRecipes(
        Arrays.asList(RegisterUploadRequestBody.RecipeURN.FEED_SHARE_IMAGE));
    registerUploadRequest.setServiceRelationships(Arrays.asList(serviceRelationships));
    RegisterUploadRequestBody registerUploadRequestBody =
        new RegisterUploadRequestBody(registerUploadRequest);
    return registerUpload(registerUploadRequestBody);
  }
  
  /**
   * Register an upload to declare the upcoming upload
   * @see <a href="https://docs.microsoft.com/en-us/linkedin/marketing/integrations/community-management/shares/vector-asset-api#register-an-upload">
   * Register an Upload</a>
   * @param registerUploadRequestBody the register upload request body
   * @return the register upload response
   */
  public RegisterUpload registerUpload(RegisterUploadRequestBody registerUploadRequestBody) {
    return linkedinClient.publish(ASSETS, RegisterUpload.class, registerUploadRequestBody,
        Parameter.with(ACTION_KEY, REGISTER_UPLOAD));
  }
  
  /**
   * Upload the asset file
   * @see <a href="https://docs.microsoft.com/en-us/linkedin/marketing/integrations/community-management/shares/vector-asset-api#upload-the-asset">
   * Upload the Asset</a>
   * @param webRequestor the web requestor - Note that it must not have any existing authorization
   * tokens
   * @param uploadURL the uploadUrl from the register upload response
   * @param headers the headers from the register upload response
   * @param filename the file name of the file to be uploaded
   * @param file the file to upload
   * @return the map of headers from the request
   * @throws IOException IOException
   */
  public static Map<String, String> uploadAsset(WebRequestor webRequestor, URL uploadURL,
      Map<String, String> headers, String filename, File file) throws IOException {
    InputStream videoInputStream = new FileInputStream(file);
    byte[] bytes = new byte[(int) file.length()];
    videoInputStream.read(bytes);
    return uploadAsset(webRequestor, uploadURL, headers, filename, bytes);
  }
  
  /**
   * Upload the asset bytes, this should be used to upload each asset chunk
   * @see <a href="https://docs.microsoft.com/en-us/linkedin/marketing/integrations/community-management/shares/vector-asset-api#upload-the-asset">
   * Upload the Asset</a>
   * @param webRequestor the web requestor - Note that it must not have any existing authorization
   * tokens
   * @param uploadURL the uploadUrl from the register upload response
   * @param headers the headers from the register upload response
   * @param filename the file name of the file to be uploaded
   * @param bytes the bytes to upload
   * @return the map of headers from the request
   * @throws IOException IOException
   */
  public static Map<String, String> uploadAsset(WebRequestor webRequestor, URL uploadURL,
      Map<String, String> headers, String filename, byte[] bytes) {
    WebRequestor.Response response;
    try {
      response = webRequestor.executePut(uploadURL.toString(), null, null, headers,
          BinaryAttachment.with(filename, bytes));
    } catch (Exception ex) {
      throw new LinkedInNetworkException("LinkedIn request failed to upload the asset", ex);
    }
  
    // If there was no response error information and this was a 500
    // error, something weird happened on LinkedIn's end. Bail.
    if (HttpURLConnection.HTTP_INTERNAL_ERROR == response.getStatusCode()) {
      throw new LinkedInNetworkException("LinkedIn request failed", response.getStatusCode());
    }
  
    // If there was no response error information and this was a 401
    // error, something weird happened on LinkedIn's end. Assume it is a Oauth error.
    if (HttpURLConnection.HTTP_UNAUTHORIZED == response.getStatusCode()) {
      throw new LinkedInOAuthException("LinkedIn request failed", response.getStatusCode());
    }
    
    if (HttpURLConnection.HTTP_OK != response.getStatusCode()
        && HttpURLConnection.HTTP_CREATED != response.getStatusCode()) {
      throw new LinkedInNetworkException("LinkedIn request failed", response.getStatusCode());
    }
    
    return response.getHeaders();
  }
  
  /**
   * Complete the multipart upload
   * @see <a href="https://docs.microsoft.com/en-us/linkedin/marketing/integrations/community-management/shares/vector-asset-api#complete-multi-part-upload">
   * Complete Multi-Part Upload</a>
   * @param completeMultiPartUploadBody the complete multipart upload body
   */
  public void completeMultiPartUpload(CompleteMultiPartUploadBody completeMultiPartUploadBody) {
    linkedinClient.publish(ASSETS, String.class, completeMultiPartUploadBody, Parameter.with(
        ACTION_KEY, COMPLETE_MULTIPART_UPLOAD));
  }
  
  /**
   * Retrieve the asset information using the asset ID
   * @see <a href="https://docs.microsoft.com/en-us/linkedin/marketing/integrations/community-management/shares/vector-asset-api#check-status-of-upload">
   * Check Status of Upload</a>
   * @param digitalMediaAsset the asset id
   * @return the check status upload response
   */
  public CheckStatusUpload checkStatusOfUpload(String digitalMediaAsset) {
    return linkedinClient.fetchObject(ASSETS + "/" + digitalMediaAsset, CheckStatusUpload.class);
  }

}
