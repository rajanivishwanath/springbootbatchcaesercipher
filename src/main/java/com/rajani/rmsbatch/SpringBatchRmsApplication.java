package com.rajani.rmsbatch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

import com.rajani.rmsbatch.controller.FileUploadController;

/*@SpringBootApplication(exclude=DataSourceAutoConfiguration.class)
@EnableBatchProcessing
@ImportResource("classpath:batchjob.xml")
public class SpringBatchRmsApplication extends DefaultBatchConfigurer{

	public static void main(String[] args) throws IOException, FileNotFoundException {
	  new File(FileUploadController.uploadDirectory).mkdir();
	  SpringApplication.run(SpringBatchRmsApplication.class, args);
	}
}*/


@SpringBootApplication(exclude=DataSourceAutoConfiguration.class)
public class SpringBatchRmsApplication{

	public static void main(String[] args) throws IOException, FileNotFoundException {
	  new File(FileUploadController.uploadDirectory).mkdir();
	  SpringApplication.run(SpringBatchRmsApplication.class, args);
	}
}
