package com.file.controller;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.file.entity.Files;
import com.file.service.impl.FileServiceImpl;

// @Controller annotation is used to
// mark any java class as a controller class
@Controller
public class FileController {

	@Autowired
	FileServiceImpl fileServiceImplementation;

	// @GetMapping annotation for
	// mapping HTTP GET requests onto
	// specific handler methods. */
	@GetMapping("/")
	public String getData() {
		return "File";
	}

	// @PostMapping annotation maps HTTP POST
	// requests onto specific handler methods
	@PostMapping("/")
	public String uploadMultipartFile(@RequestParam("files") MultipartFile[] files, Model modal) {
		try {
			// Declare empty list for collect the files data
			// which will come from UI
			List<Files> fileList = new ArrayList<Files>();
			for (MultipartFile file : files) {
				String fileContentType = file.getContentType();
				String sourceFileContent = new String(file.getBytes(), StandardCharsets.UTF_8);
				String fileName = file.getOriginalFilename();
				Files fileModal = new Files(fileName, sourceFileContent, fileContentType);

				// Adding file into fileList
				fileList.add(fileModal);
			}

			// Saving all the list item into database
			fileServiceImplementation.saveAllFilesList(fileList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		// Send file list to View using modal class
		// fileServiceImplementation.getAllFiles() used to
		// fetch all file list from DB
		modal.addAttribute("allFiles", fileServiceImplementation.getAllFiles());

		return "FileList";
	}
}
