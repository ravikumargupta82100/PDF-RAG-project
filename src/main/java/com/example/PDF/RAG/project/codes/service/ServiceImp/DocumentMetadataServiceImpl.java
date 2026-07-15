package com.example.PDF.RAG.project.codes.service.ServiceImp;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.PDF.RAG.project.codes.Entity.Document;
import com.example.PDF.RAG.project.codes.Entity.enums.DocumentStatus;
import com.example.PDF.RAG.project.codes.Repository.DocumentRepository;
import com.example.PDF.RAG.project.codes.service.DocumentMetadataService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DocumentMetadataServiceImpl implements DocumentMetadataService {

	private final DocumentRepository repository;

	@Override
	public Document createDocument(String fileName, String filePath) {

		Document document = Document.builder().fileName(fileName).filePath(filePath).status(DocumentStatus.UPLOADED)
				.uploadedAt(LocalDateTime.now()).build();

		return repository.save(document);
	}

}
