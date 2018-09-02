package com.booking.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.spring.guides.gs_producing_web_service.GetTaskRequest;
import io.spring.guides.gs_producing_web_service.GetTaskResponse;


@Endpoint
public class CountryEndpoint {
	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

	private MaventaskRepository maventaskRepository;

	@Autowired
	public CountryEndpoint(MaventaskRepository maventaskRepository) {
		this.maventaskRepository = maventaskRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getTaskRequest")
	@ResponsePayload
	public GetTaskResponse getCountry(@RequestPayload GetTaskRequest request) {
		GetTaskResponse response = new GetTaskResponse();
		response.setTask(maventaskRepository.findTask(request.getName()));
		return response;
	}
}