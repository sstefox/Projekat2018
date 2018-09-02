package com.agent.main;



import java.util.concurrent.Executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.agent.main.soapclient.TaskClient;
import com.agent.main.wsdl.GetTaskResponse;


@SpringBootApplication
public class AgentApplication {

	Logger logger = LoggerFactory.getLogger(AgentApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(AgentApplication.class, args);
	}
	
//	@Bean
//	CommandLineRunner lookup(TaskClient quoteClient) {
//		return args -> {
//			GetTaskResponse responseDiff = quoteClient.getTask("difference");
//			logger.info("Going to execute task for finding out database differences with response"+responseDiff.getTask().getGoal());
//			GetTaskResponse responseUpdate = quoteClient.getTask("update");
//			logger.info("Going to execute task for finding out database differences with response"+responseUpdate.getTask().getGoal());
//		};
//	}
}
