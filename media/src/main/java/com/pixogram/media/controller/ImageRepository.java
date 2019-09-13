package com.pixogram.media.controller;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<ImageModel, Long> {

	List<ImageModel> findByUsername(String username);
}