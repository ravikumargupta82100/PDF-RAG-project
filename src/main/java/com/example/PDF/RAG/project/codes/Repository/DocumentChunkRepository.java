package com.example.PDF.RAG.project.codes.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.PDF.RAG.project.codes.Entity.DocumentChunk;

@Repository
public interface DocumentChunkRepository extends JpaRepository<DocumentChunk, Long> {

	@Query(value = """
			SELECT *
			FROM document_chunk
			ORDER BY embedding <=> CAST(:embedding AS vector)
			LIMIT :limit
			""", nativeQuery = true)
	List<DocumentChunk> findSimilarChunks(@Param("embedding") String embedding, @Param("limit") int limit);
}