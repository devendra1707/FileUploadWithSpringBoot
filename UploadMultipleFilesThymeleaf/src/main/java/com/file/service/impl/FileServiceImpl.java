package com.file.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.file.entity.Files;
import com.file.repository.FileRepository;
import com.file.service.FileService;

// @Service annotation is used with classes
// that provide some business functionalities
@Service
public class FileServiceImpl implements FileService {

	// @Autowired annotation used to inject
	// the object dependency of FileRepository
	@Autowired
	FileRepository fileRepository;

	@Override
	public List<Files> getAllFiles() {
		// fetch all the files form database
		return fileRepository.findAll();
	}

	public void saveAllFilesList(List<Files> fileList) {
		// Save all the files into database
		for (Files fileModal : fileList)
			fileRepository.save(fileModal);
	}
}
