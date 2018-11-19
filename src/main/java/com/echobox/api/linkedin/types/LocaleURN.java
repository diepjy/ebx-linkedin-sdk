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

package com.echobox.api.linkedin.types;

import lombok.Getter;

/**
 * LocalURN POJO - The Locale object represents a country and language
 * @see <a href="https://developer.linkedin.com/docs/ref/v2/object-types#Locale">Locale</a>
 * @author joanna
 *
 */
public class LocaleURN extends URN {

  /**
   * An uppercase two-letter country code as defined by ISO-3166
   */
  @Getter
  private Locale local;
  
  /**
   * A lowercase two-letter language code as defined by ISO-639.
   */
  @Getter
  private String name;
  
}
