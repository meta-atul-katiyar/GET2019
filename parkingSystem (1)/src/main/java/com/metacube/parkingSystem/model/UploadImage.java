package com.metacube.parkingSystem.model;

import org.springframework.web.multipart.MultipartFile;

public class UploadImage {
	 private MultipartFile file;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
	 
}
