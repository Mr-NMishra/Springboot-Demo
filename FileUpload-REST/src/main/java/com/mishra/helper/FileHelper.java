package com.mishra.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileHelper {
	
	//adding final folder
	private final String DIR_UPLD="/home/nick/Desktop/Git-Repos/Springboot-11-01-22/FileUpload-REST"
			+ "/src/main/resources/static/uploads/Images";

	//uploading file
	public boolean uploadFie(MultipartFile file) {
		boolean flag=false;
		try {
			//here we are reading the data
			InputStream inputStream= file.getInputStream();
			byte[] bytes= file.getBytes();
			inputStream.read(bytes);
			System.out.println(inputStream);
			
			//now writing the data into folder
			FileOutputStream outputStream= new FileOutputStream(DIR_UPLD+File.separator+file.getOriginalFilename());
			outputStream.write(bytes);
			outputStream.close();
			inputStream.close();
			flag=true;
			return flag;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return flag;
		}
	}
}
