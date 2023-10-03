package com.file.service;

import java.util.List;

import com.file.entity.Files;

public interface FileService {
	public List<Files> getAllFiles();

	public void saveAllFilesList(List<Files> fileList);
}
