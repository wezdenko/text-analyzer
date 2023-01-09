package com.example.TextAnalyzer.controller;

import com.example.TextAnalyzer.model.AnalyzedWord;
import com.example.TextAnalyzer.service.TextAnalyzerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api")
public class TextAnalyzerController {

    private final TextAnalyzerService textAnalyzerService;

    public TextAnalyzerController(TextAnalyzerService textAnalyzerService) {
        this.textAnalyzerService = textAnalyzerService;
    }

    @PostMapping(path = "/analyze")
    public ResponseEntity<List<AnalyzedWord>> analyze(@RequestBody String text) {
        return ResponseEntity.ok(textAnalyzerService.analyze(text));
    }

    @GetMapping(path = "analyzed/{word}")
    public ResponseEntity<AnalyzedWord> get(String word) {
        return ResponseEntity.ok(textAnalyzerService.getAnalyzedWord(word));
    }
}
