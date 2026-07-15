package com.example.PDF.RAG.project.codes.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.PDF.RAG.project.codes.Entity.Document;
import com.example.PDF.RAG.project.codes.Entity.DocumentChunk;
import com.example.PDF.RAG.project.codes.service.ServiceImp.ChunckingServiceImp;
import com.example.PDF.RAG.project.codes.service.ServiceImp.DocumentMetadataServiceImpl;
import com.example.PDF.RAG.project.codes.service.ServiceImp.DocumentServiceImp;
import com.example.PDF.RAG.project.codes.service.ServiceImp.FileStorageServiceImpl;
import com.example.PDF.RAG.project.codes.service.ServiceImp.SearchService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/document")
@RequiredArgsConstructor
@CrossOrigin("*")
public class DocumentController {
	private final ChunckingServiceImp serviceImp;
	private final DocumentServiceImp documentServiceImp;
	private final SearchService searchService;

	private final FileStorageServiceImpl fileStorageService;
	private final DocumentMetadataServiceImpl documentMetadataService;

	@GetMapping
	public String testApi() {
		return "Hello from Spring AI";
	}

	@PostMapping("/upload")
	public ResponseEntity<List<String>> uploadDocument(@RequestParam("file") MultipartFile file) {

		String path = fileStorageService.saveFile(file);

		Document document = documentMetadataService.createDocument(file.getOriginalFilename(), path);

		List<String> chunks = serviceImp.exactText(file);

		documentServiceImp.saveChunks(file.getOriginalFilename(), chunks);

		return new ResponseEntity<>(chunks, HttpStatus.OK);
	}

	@GetMapping("/chunks")
	public List<DocumentChunk> getAllChunks() {
		return documentServiceImp.getChunks();
	}

	@GetMapping("/search")
	public String chat(@RequestParam String question) {

		return searchService.ask(question);
	}
}
