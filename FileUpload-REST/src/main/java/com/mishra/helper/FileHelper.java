package com.mishra.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileHelper {

	/*
	 * adding final folder this is static means all folders are reuired in same
	 * order
	 */

//	private final String DIR_UPLD="/home/nick/Desktop/Git-Repos/Springboot-11-01-22/FileUpload-REST"
//			+ "/src/main/resources/static/uploads/Images";

	/* Now Creating Dyanmic path so our project Directory is dependent not other */
	private final String DIR_UPLD = new ClassPathResource("static/uploads/Images").getFile().getAbsolutePath();
	//Default constructor to handel Excpetion throws by final path 
	FileHelper() throws IOException {

	}

	// uploading file
	public boolean uploadFie(MultipartFile file) {
		
		boolean flag = false;
		try {
			/* here we are reading the data */
			InputStream inputStream = file.getInputStream();
			byte[] bytes = file.getBytes();
			inputStream.read(bytes);
			// now writing the data into folder
			// DIR_UPLD is qualified folder name in string formate
			FileOutputStream outputStream = new FileOutputStream(
					DIR_UPLD + File.separator + file.getOriginalFilename());
			outputStream.write(bytes);
			outputStream.close();
			inputStream.close();

			/* OR WE CAN ALSO USE POWERFULL NIO FEATURE */
			// here we use Paths to convert our destination from String to Path

			Files.copy(file.getInputStream(), Paths.get(DIR_UPLD + File.separator + file.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);

			flag = true;
			return flag;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return flag;
		}
	}
}
