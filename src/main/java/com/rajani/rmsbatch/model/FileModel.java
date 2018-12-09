package com.rajani.rmsbatch.model;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public class FileModel {
	private MultipartFile[] file;
	private int threads;
	
	public FileModel() {}
	
	public FileModel(MultipartFile[] file, int threads) {
		this.file = file;
		this.threads = threads;
	}
	public MultipartFile[] getFile() {
		return file;
	}
	public void setFilePath(MultipartFile[] file) {
		this.file = file;
	}
	public int getthreads() {
		return threads;
	}
	public void setthreads(int threads) {
		this.threads = threads;
	}
}
