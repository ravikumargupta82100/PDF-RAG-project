package com.example.PDF.RAG.project.codes.service;

import java.util.List;

import com.example.PDF.RAG.project.codes.Entity.DocumentChunk;

public interface DocumentService {
	List<DocumentChunk> getChunks();

}
