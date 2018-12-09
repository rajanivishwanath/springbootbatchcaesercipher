package com.rajani.rmsbatch.tasklet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import com.rajani.rmsbatch.caesarcipher.CaesarCipher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class Tasklet2 extends AbstracTasklet implements Tasklet {
	
	Logger log = LoggerFactory.getLogger(this.getClass().getName());
	public static int CAEASEP_CIPHER_SHIFT=10;
	public Tasklet2(){
		log.info("Construction - # Tasklet 2");
	}
	
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

		System.out.println("### Processing! Encrypt and Write to File: " + fileName);
		
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			if (!new File(fileName).exists()) {
				try (BufferedWriter bw = new BufferedWriter(new FileWriter("EncryptedFile.txt"))) {
					stream.forEach(encryptedText->{
									try {
										bw.write(CaesarCipher.encrypt(encryptedText, CAEASEP_CIPHER_SHIFT).toString());
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									});
				}
			    catch (IOException e) {
					e.printStackTrace();
				}
			}
		} 
		
		return RepeatStatus.FINISHED;
	}
}