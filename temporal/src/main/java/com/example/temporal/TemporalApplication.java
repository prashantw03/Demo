package com.example.temporal;

import com.example.temporal.temporal.Activity;
import com.example.temporal.temporal.WorkFlow;
import com.example.temporal.temporal.WorkflowImpl;
import io.temporal.client.WorkflowClient;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TemporalApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext appContext = SpringApplication.run(TemporalApplication.class, args);
		//
		WorkerFactory factory = appContext.getBean(WorkerFactory.class);
		Activity signUpActivity = appContext.getBean(Activity.class);
		//Worker responsible for Workflow
		Worker worker = factory.newWorker(WorkFlow.QUEUE_NAME);
		worker.registerWorkflowImplementationTypes(WorkflowImpl.class);
		worker.registerActivitiesImplementations(signUpActivity);
		factory.start();
		//
	}


}
