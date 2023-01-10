package com.example.TextAnalyzer.repository;

import com.example.TextAnalyzer.model.AnalyzedWord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalyzedWordRepository extends JpaRepository<AnalyzedWord, String> {
}
