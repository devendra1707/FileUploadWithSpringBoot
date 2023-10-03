package com.file.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.file.entity.FileData;
import com.file.repository.FileRepository;
import com.file.utils.FileUtils;

@Service
public class FileService {
	@Autowired
	private FileRepository storageRepository;

	public String uploadImage(MultipartFile[] file) throws IOException {
		FileData[] fileData = storageRepository.save(FileData.builder().name(file.getOriginalFilename())
				.type(file.getContentType()).imageData(FileUtils.compressImage(file.getBytes())).build());
		if (fileData != null) {
			return "file uploaded successfully : " + file.getOriginalFilename();
		}
		return null;
	}

	public byte[] downloadImage(String fileName) {
		Optional<FileData> dbImageData = storageRepository.findByName(fileName);
		byte[] images = FileUtils.decompressImage(dbImageData.get().getImageData());
		return images;
	}
}