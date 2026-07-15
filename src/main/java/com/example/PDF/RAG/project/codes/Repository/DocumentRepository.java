package com.example.PDF.RAG.project.codes.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.PDF.RAG.project.codes.Entity.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {

}
