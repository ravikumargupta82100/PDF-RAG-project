package com.example.PDF.RAG.project.codes.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {

	String saveFile(MultipartFile file);

}