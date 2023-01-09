package com.example.TextAnalyzer.service;

import com.example.TextAnalyzer.model.AnalyzedWord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TextAnalyzerServiceTest {

    private TextAnalyzerService textAnalyzerService;

    @BeforeEach
    void beforeEach() {
        textAnalyzerService = new TextAnalyzerService();
    }

    @Test
    void analyze() {
        var expected = List.of(
                new AnalyzedWord("Ola", 1, List.of(0)),
                new AnalyzedWord("poszła", 1, List.of(1)),
                new AnalyzedWord("do", 3, List.of(2, 3, 5)),
                new AnalyzedWord("przedszkola", 1, List.of(4))
        );

        var result = textAnalyzerService.analyze("Ola-poszła ..do. ((do)) przedszkola,.<\" do");

        assertEquals(expected, result);
    }
}