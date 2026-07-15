package com.example.PDF.RAG.project.codes.service.ServiceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.PDF.RAG.project.codes.Entity.DocumentChunk;
import com.example.PDF.RAG.project.codes.Repository.DocumentChunkRepository;
import com.example.PDF.RAG.project.codes.Repository.DocumentRepository;
import com.example.PDF.RAG.project.codes.service.DocumentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DocumentServiceImp implements DocumentService {

	private final DocumentChunkRepository documentChunkRepository;
	private final EmbeddingService embeddingService;
	private final DocumentRepository repository;

	public void saveChunks(String documentName, List<String> chunks) {
		List<DocumentChunk> entities = new ArrayList<>();

		for (int i = 0; i < chunks.size(); i++) {
			float[] embedding = embeddingService.generateEmbedding(chunks.get(i));
			DocumentChunk chunk = DocumentChunk.builder().documentName(documentName).chunkIndex(i + 1)
					.chunkText(chunks.get(i)).embedding(embedding).build();
			entities.add(chunk);
		}

		documentChunkRepository.saveAll(entities);
	}

	@Override
	public List<DocumentChunk> getChunks() {

		return documentChunkRepository.findAll();
	}

}
