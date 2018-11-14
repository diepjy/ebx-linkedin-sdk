/**
 * Copyright (c) 2010-2017 Mark Allen, Norbert Bartels.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.echobox.api.linkedin.exception;

import org.json.JSONObject;

/**
 * Specifies a method for mapping LinkedIn API exceptions to corresponding instances of
 * {@code LinkedInException}.
 * 
 * @author <a href="http://restfb.com">Mark Allen</a>
 */
public interface LinkedInExceptionMapper {
  /**
   * Given a LinkedIn API exception type and message, generates an instance of the corresponding
   * {@code LinkedInGraphException} or one of its subclasses.
   * 
   * @param errorCode
   *          LinkedIn API exception error code field, e.g. 190.
   * @param httpStatusCode
   *          The HTTP status code returned by the server, e.g. 500.
   * @param message
   *          LinkedIn API message field, e.g. "Invalid access token signature."
   * @param isTransient
   *          Whether the error is transient
   * @param rawError
   *          raw error message as JSON
   * @return An appropriate {@code LinkedInException} subclass.
   */
  LinkedInException exceptionForTypeAndMessage(Integer errorCode, Integer httpStatusCode,
      String message, Boolean isTransient, JSONObject rawError);
}
