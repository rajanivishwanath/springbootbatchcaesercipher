package com.rajani.rmsbatch.job;


import javax.batch.operations.JobRestartException;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;

@ImportResource("classpath:batchjob.xml")
public class SpringBatchJob extends DefaultBatchConfigurer{
	@Autowired
	JobLauncher jobLauncher;
	 
	@Autowired
	Job job;
	
	String fileNameAndPath;
	int threadCount;
	
	public SpringBatchJob(String fileNameAndPath,int threadcount) {
		// TODO Auto-generated constructor stub
		this.fileNameAndPath = fileNameAndPath;
		this.threadCount = threadcount;
		System.out.println(this.fileNameAndPath+this.threadCount);
	}
	
	public void run() {
		try {
			JobParameters jobParameters = new JobParametersBuilder()
					.addString("input.file.name", fileNameAndPath.toString())
					.addLong("thread", Long.valueOf(threadCount))
           		    .addLong("time", System.currentTimeMillis())
					.toJobParameters();
			 jobLauncher.run(job, jobParameters);
		} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException | JobParametersInvalidException | org.springframework.batch.core.repository.JobRestartException e) {
			e.printStackTrace();
		}
   }
}
