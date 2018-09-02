package com.booking.config;

import javax.annotation.PostConstruct;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import io.spring.guides.gs_producing_web_service.Goal;
import io.spring.guides.gs_producing_web_service.Maventask;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class MaventaskRepository {
	private static final Map<String, Maventask> tasks = new HashMap<>();
	@Value( "${maven.path}" )
	private String mavenPath;
	private Process process =null;	
	@PostConstruct
	public void initData() {
		Maventask t1 = new Maventask();
		t1.setName("difference");
		t1.setGoal(Goal.LIQUIBASE_DIFF);
		Maventask t2 = new Maventask();
		t2.setName("update");
		t2.setGoal(Goal.LIQUIBASE_UPDATE);
		tasks.put(t1.getName(), t1);
		tasks.put(t2.getName(), t2);
	}

	public Maventask findTask(String name) {
		try {
			   String task = tasks.get(name).getGoal().name();
			   System.out.println("Task Name **************"+task);
			   if(task.equals("LIQUIBASE_DIFF")) {
				   process = Runtime.getRuntime().exec(mavenPath+" "+"liquibase:diff");
			   }else {
				   process = Runtime.getRuntime().exec(mavenPath+" "+"liquibase:update");
			   }
			   copy(process.getInputStream(),System.out);
		}catch(IOException e)
		  {
		     System.err.println("Error on inStream.readLine()");
		     e.printStackTrace();  
		  }
		return tasks.get(name);
	}
	static void copy(InputStream in, OutputStream out) throws IOException {
	    while (true) {
	        int c = in.read();
	        if (c == -1)
	            break;
	        out.write((char) c);
	    }
	}
}