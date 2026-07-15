package com.example.PDF.RAG.project.codes.Entity;

import java.time.LocalDateTime;

import com.example.PDF.RAG.project.codes.Entity.enums.DocumentStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "documents")
public class Document {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String fileName;

	@Column(nullable = false)
	private String filePath;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private DocumentStatus status;

	@Column(nullable = false)
	private LocalDateTime uploadedAt;

}
