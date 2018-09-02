package com.agent.main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.agent.main.soapclient.TaskClient;

@Configuration
public class TaskConfiguration {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in
		// pom.xml
		marshaller.setContextPath("com.agent.main.wsdl");
		return marshaller;
	}

	@Bean(name="taskClient")
	public TaskClient countryClient(Jaxb2Marshaller marshaller) {
		TaskClient client = new TaskClient();
		client.setDefaultUri("http://localhost:8080/ws");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

}