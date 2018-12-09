package com.rajani.rmsbatch.controller;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.rajani.rmsbatch.job.SpringBatchJob;
import com.rajani.rmsbatch.model.FileModel;

@Controller
public class FileUploadController {

	public static String uploadDirectory = System.getProperty("user.dir")+"/uploads";
	
	
	@RequestMapping("/")
	public String uploadPage(Model model) {
		//System.out.println(System.getProperty("user.dir"));
		FileModel fileModel = new FileModel();
		model.addAttribute("fileModel", fileModel);
		return "uploadview";
	}
	
	   public String upload(Model model,@RequestParam("files") MultipartFile[] files, @RequestParam("threads") int threadCnt) 
	   {
	 	  StringBuilder fileNames = new StringBuilder();
	 	  for (MultipartFile file : files) {
	 		  Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
	 		  fileNames.append(file.getOriginalFilename()+" ");
	 		 
	 		 SpringBatchJob batchJob = new SpringBatchJob(fileNameAndPath.toString(), threadCnt);
			batchJob.run();
	 	  }
	 	  model.addAttribute("message", "Successfully uploaded files "+fileNames.toString()+" thread count  "+threadCnt);
	 	  
	 	  return "uploadview";
	   }
}	   

