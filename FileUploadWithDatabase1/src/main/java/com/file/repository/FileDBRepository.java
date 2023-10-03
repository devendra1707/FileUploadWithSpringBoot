package com.file.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.file.entity.FileDB;

public interface FileDBRepository extends JpaRepository<FileDB, String> {

}
