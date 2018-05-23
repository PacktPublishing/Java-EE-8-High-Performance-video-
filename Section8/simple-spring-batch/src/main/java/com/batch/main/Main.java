package com.batch.main;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import de.viadee.spring.batch.infrastructure.Configurator;


@Configuration
@ImportResource({"classpath:/spring/batch/jobs/job.xml"})//load configuration file from classpath
@Import(Configurator.class)
public class Main {

	public static void main(String[] args) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {

		//String springConfig="H:/workspace/SimplSpringBatchUsingAnn/src/com/spring/config/job.xml";
		//@SuppressWarnings("resource")
		//ApplicationContext context = new FileSystemXmlApplicationContext("file:"+springConfig);
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(Main.class);
		context.refresh();
		//load jobLauncher details from job.xml file
		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
		//load Job details from job.xml file
		Job job = (Job) context.getBean("loadJob");
		//run job
		JobExecution execution = jobLauncher.run(job, new JobParameters());
		System.out.println("Exit Status : " + execution.getStatus());



	}

}


