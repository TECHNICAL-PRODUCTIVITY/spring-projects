package com.productivity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.productivity.service.MinioService;

@RestController
public class MinioController {
	
	@Autowired
	MinioService minioService;

	@PostMapping("/upload")
	public String uploadFile(@RequestParam("file") MultipartFile file) {
		return minioService.uploadFile(file);
	}
}
