package com.mishra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mishra.helper.FileHelper;

@RestController
public class Filecltr {
	@Autowired
	private FileHelper fileHelper;

	@PostMapping("upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile multipartFile) {
		System.out.println(multipartFile.getContentType());
		if (multipartFile.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("File Not Found");
		}
		if (!multipartFile.getContentType().equals("image/png")) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid File Type");
		}
		fileHelper.uploadFie(multipartFile);
		return ResponseEntity.ok("Test Sucessfull");
	}
}
