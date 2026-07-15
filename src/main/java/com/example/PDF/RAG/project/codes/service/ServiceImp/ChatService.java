package com.example.PDF.RAG.project.codes.service.ServiceImp;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatService {

	private final ChatClient chatClient;

	public String ask(String context, String question) {

		return chatClient.prompt().system("""
				You are a helpful AI assistant.
				Answer ONLY from the provided context.
				If the answer is not present in the context,
				reply: "I don't know based on the uploaded document."
				""").user("""
				Context:

				%s

				Question:

				%s
				""".formatted(context, question)).call().content();
	}
}