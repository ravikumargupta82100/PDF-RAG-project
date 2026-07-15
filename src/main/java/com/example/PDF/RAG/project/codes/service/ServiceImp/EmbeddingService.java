package com.example.PDF.RAG.project.codes.service.ServiceImp;

import java.util.List;

import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.embedding.EmbeddingResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service

public class EmbeddingService {
	private final EmbeddingModel embeddingModel;

	public EmbeddingService(@Qualifier("ollamaEmbeddingModel") EmbeddingModel embeddingModel) {
		this.embeddingModel = embeddingModel;
	}

	public float[] generateEmbedding(String text) {

		EmbeddingResponse response = embeddingModel.embedForResponse(List.of(text));

		return response.getResults().get(0).getOutput();
	}
}