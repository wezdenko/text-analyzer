package com.example.TextAnalyzer.service;

import com.example.TextAnalyzer.model.AnalyzedWord;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TextAnalyzerService {

    public List<AnalyzedWord> analyze(String text) {
        var words = text.split("\\s+");
        var analyzedWords = new ArrayList<AnalyzedWord>();

        for (int i = 0; i < words.length; i++) {
            analyzedWords.add(new AnalyzedWord(words[i], 1, List.of(i)));
        }

        return analyzedWords;
    }
}
