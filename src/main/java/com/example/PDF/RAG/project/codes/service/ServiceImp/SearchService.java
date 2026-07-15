package com.example.PDF.RAG.project.codes.service.ServiceImp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.PDF.RAG.project.codes.Entity.DocumentChunk;
import com.example.PDF.RAG.project.codes.Repository.DocumentChunkRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SearchService {

	private final EmbeddingService embeddingService;
	private final DocumentChunkRepository repository;
	private final ChatService chatService;

	public String ask(String question) {

		float[] embedding = embeddingService.generateEmbedding(question);

		List<DocumentChunk> chunks = repository.findSimilarChunks(Arrays.toString(embedding), 3);

		String context = chunks.stream().map(DocumentChunk::getChunkText).collect(Collectors.joining("\n\n"));

		return chatService.ask(context, question);
	}
}