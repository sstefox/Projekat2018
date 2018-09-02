package com.agent.main.soapclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.agent.main.wsdl.GetTaskRequest;
import com.agent.main.wsdl.GetTaskResponse;



public class TaskClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(TaskClient.class);

	public GetTaskResponse getTask(String country) {

		GetTaskRequest request = new GetTaskRequest();
		request.setName(country);

		log.info("Requesting location for " + country);

		GetTaskResponse response = (GetTaskResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/ws/countries", request,
						new SoapActionCallback(
								"http://spring.io/guides/gs-producing-web-service/GetCountryRequest"));

		return response;
	}

}