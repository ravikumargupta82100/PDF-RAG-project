package com.example.PDF.RAG.project.codes.service.ServiceImp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.PDF.RAG.project.codes.service.FileStorageService;

@Service
public class FileStorageServiceImpl implements FileStorageService {

	@Value("${app.file.upload-dir}")
	private String uploadDir;

	@Override
	public String saveFile(MultipartFile file) {

		try {

			Path uploadPath = Paths.get(uploadDir);

			if (!Files.exists(uploadPath)) {
				Files.createDirectories(uploadPath);
			}

			Path filePath = uploadPath.resolve(file.getOriginalFilename());

			Files.copy(file.getInputStream(), filePath);

			return filePath.toString();

		} catch (IOException e) {
			throw new RuntimeException("Unable to store file", e);
		}

	}

}