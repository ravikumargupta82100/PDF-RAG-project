package com.example.PDF.RAG.project.codes.service.ServiceImp;

import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.web.multipart.MultipartFile;

import com.example.PDF.RAG.project.codes.service.Service;

import lombok.RequiredArgsConstructor;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ChunckingServiceImp implements Service {

	@Override
	public List<String> exactText(MultipartFile file) {

		try (PDDocument document = Loader.loadPDF(file.getBytes())) {
			PDFTextStripper stripper = new PDFTextStripper();

			return chunkingText(stripper.getText(document));
		}

		catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}

	}

	@Override
	public List<String> chunkingText(String st) {

		int chunkSize = 500;

		List<String> chunks = new ArrayList<>();

		for (int i = 0; i < st.length(); i += chunkSize) {

			chunks.add(st.substring(i, Math.min(i + chunkSize, st.length())));
		}

		return chunks;
	}

}
