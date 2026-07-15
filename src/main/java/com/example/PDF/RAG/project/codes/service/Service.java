package com.example.PDF.RAG.project.codes.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface Service {

	public List<String> exactText(MultipartFile file);

	public List<String> chunkingText(String st);

}
