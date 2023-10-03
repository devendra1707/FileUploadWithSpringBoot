package com.file.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.file.entity.Files;

// @Repository annotation is used to
// indicate that the class provides the mechanism
// for storage, retrieval, search,update and delete
// operation on objects.
@Repository
public interface FileRepository extends JpaRepository<Files, Long> {

}
