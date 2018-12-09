package com.rajani.rmsbatch.tasklet;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.Line;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.util.FileUtils;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.core.io.FileSystemResource;

public class Tasklet1 extends AbstracTasklet implements Tasklet {

	Logger log = LoggerFactory.getLogger(this.getClass().getName());

	public Tasklet1() {
		log.info("Construction - # Tasklet 1");
	}

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

		System.out.println("### Processing! Read content of File: " + fileName);
		FlatFileItemReader<AbstracTasklet> itemReader = new FlatFileItemReader<AbstracTasklet>();
		itemReader.setResource(new FileSystemResource(fileName));
		// DelimitedLineTokenizer defaults to comma as its delimiter
		DefaultLineMapper<AbstracTasklet> lineMapper = new DefaultLineMapper<AbstracTasklet>();
		lineMapper.setLineTokenizer(new DelimitedLineTokenizer());
		itemReader.setLineMapper(lineMapper);
		itemReader.open(new ExecutionContext());
		AbstracTasklet fileRead = itemReader.read();

		return RepeatStatus.FINISHED;
	}

}