/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH
 * under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright
 * ownership. Camunda licenses this file to you under the Apache License,
 * Version 2.0; you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.platform.runtime.example;

import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.core5.util.Timeout;
import org.camunda.bpm.client.ExternalTaskClient;

public class TestParallel {

	  public static void main(String... args) {
	    // bootstrap the client
	    ExternalTaskClient client = ExternalTaskClient.create()
	      .baseUrl("http://localhost:8080/engine-rest")
	      .asyncResponseTimeout(1000)
	      .customizeHttpClient(httpClientBuilder -> {
	        httpClientBuilder.setDefaultRequestConfig(RequestConfig.custom()
	          .setResponseTimeout(Timeout.ofSeconds(15))
	          .build());
	      })
	      .build();



	    client.subscribe("parallel")
	      .handler((externalTask, externalTaskService) -> {
	       
	        externalTaskService.handleFailure(externalTask, "fail", "faillll", 0, 0);
	      }).open();
	  }

	}
