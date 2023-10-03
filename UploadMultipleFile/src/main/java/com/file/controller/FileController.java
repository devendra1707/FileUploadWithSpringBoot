package com.file.controller;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/file")
public class FileController {

	private Logger logger = LoggerFactory.getLogger(FileController.class);

	@Autowired
	private MultipartFile multipartFile;
	
	@PostMapping(value = "/upload")
	public ResponseEntity<?> uploadMultipleFile(@RequestParam("images") MultipartFile[] files) {
		this.logger.info("{} number of files uploaded", files.length);
		Arrays.stream(files).forEach(MultipartFile -> {

			logger.info("file name : {} ", multipartFile.getOriginalFilename());
			logger.info("file type : {} ", multipartFile.getContentType());

		});

		return ResponseEntity.ok("File Uploaded");
	}
}