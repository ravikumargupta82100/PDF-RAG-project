package com.example.PDF.RAG.project.codes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PDF.RAG.project.codes.service.ServiceImp.EmbeddingService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/test")
public class EmbeddingController {

	private final EmbeddingService embeddingService;

	@GetMapping("/embedding")
	public String embedding() {

		float[] vector = embeddingService.generateEmbedding("Spring Boot and Hibernate");

		return "Dimensions = " + vector.length;
	}
}