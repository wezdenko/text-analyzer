package com.example.TextAnalyzer.service;

import com.example.TextAnalyzer.model.AnalyzedWord;
import com.example.TextAnalyzer.repository.AnalyzedWordRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TextAnalyzerServiceTest {

    private TextAnalyzerService textAnalyzerService;
    @Mock
    private AnalyzedWordRepository analyzedWordRepository;

    @BeforeEach
    void beforeEach() {
        textAnalyzerService = new TextAnalyzerService(analyzedWordRepository);
    }

    @Test
    void analyze() {
        var expected = List.of(
                new AnalyzedWord("do", 3, List.of(2, 3, 5)),
                new AnalyzedWord("Ola", 1, List.of(0)),
                new AnalyzedWord("poszła", 1, List.of(1)),
                new AnalyzedWord("przedszkola", 1, List.of(4))
        );

        var result = textAnalyzerService.analyze("Ola-poszła ..do. ((do)) przedszkola,.<\" do");

        assertEquals(expected, result);
    }
}