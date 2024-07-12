package com.service;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class EFileUploadService {
	public void uploadProductImage(MultipartFile masterImage) {
		
		String path = "C:\\Users\\vedbo\\Documents\\workspace-spring-tool-suite-4-4.22.1.RELEASE\\Spring-Web-Demo\\src\\main\\webapp\\images\\products";
		
		try {
			byte image_array[] = masterImage.getBytes();
			
			File file = new File(path,masterImage.getOriginalFilename());
			FileUtils.writeByteArrayToFile(file, image_array);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void uploadUserImage(MultipartFile masterImage, String email) {
		
		String path = "C:\\Users\\vedbo\\Documents\\workspace-spring-tool-suite-4-4.22.1.RELEASE\\Spring-Web-Demo\\src\\main\\webapp\\images\\profilepic";
		File dir = new File(path,email);
		dir.mkdir();
		
		try {
			byte image_array[] = masterImage.getBytes();
			
			File file = new File(dir, masterImage.getOriginalFilename());
			FileUtils.writeByteArrayToFile(file, image_array);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
