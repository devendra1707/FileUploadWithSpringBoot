package com.file.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.file.entity.FileData;

@Repository
public interface StorageRepository extends JpaRepository<FileData, Long> {

 	 Optional<FileData> findByName(String fileName);
}
