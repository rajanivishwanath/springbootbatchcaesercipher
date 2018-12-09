package com.rajani.rmsbatch.tasklet;

public abstract class AbstracTasklet {
	protected Long thread;
	protected String fileName;

	public Long getThread() {
		return thread;
	}

	public void setThread(Long thread) {
		this.thread = thread;
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}