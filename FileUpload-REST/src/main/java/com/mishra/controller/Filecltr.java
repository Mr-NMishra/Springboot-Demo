package com.mishra.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mishra.helper.FileHelper;

@RestController
public class Filecltr {
	@Autowired
	private FileHelper fileHelper ;

	@PostMapping("upload-file")
	public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile multipartFile) {
		if (multipartFile.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("File Not Found");
		}
		if (!multipartFile.getContentType().equals("image/png")) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid File Type");
		}
		boolean flag=fileHelper.uploadFie(multipartFile);
		//This returns only Text 
		//return ResponseEntity.ok("Test Sucessfull");
		//Now we sending absolute directory
		if (flag) {
			return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/upload-file/").path(multipartFile.getOriginalFilename()).toUriString());

		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
			}
}
