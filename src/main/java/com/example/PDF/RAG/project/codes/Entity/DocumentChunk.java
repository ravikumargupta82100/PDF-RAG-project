package com.example.PDF.RAG.project.codes.Entity;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "document_chunk")

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DocumentChunk {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String documentName;

	private Integer chunkIndex;

	@Column(columnDefinition = "TEXT")
	private String chunkText;

	@Column(columnDefinition = "vector(768)")
	@JdbcTypeCode(SqlTypes.VECTOR)
	private float[] embedding;
}