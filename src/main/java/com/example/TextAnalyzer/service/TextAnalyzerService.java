package com.example.TextAnalyzer.service;

import com.example.TextAnalyzer.model.AnalyzedWord;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TextAnalyzerService {

    public List<AnalyzedWord> analyze(String text) {
        var words = text.split("[^A-Za-ząćęłńóśźż]+");
        var analyzedWords = new ArrayList<AnalyzedWord>();

        for (int i = 0; i < words.length; i++) {
            processWord(analyzedWords, words[i], i);
        }
        return analyzedWords
                .stream()
                .sorted(Comparator.comparing(word -> word.getWord().toLowerCase()))
                .collect(Collectors.toList());
    }

    private void processWord(List<AnalyzedWord> analyzedWords, String word, int position) {
        var doesWordAlreadyExist = addPositionIfWordExists(analyzedWords, word, position);
        if (!doesWordAlreadyExist) {
            var positions = new ArrayList<Integer>();
            positions.add(position);
            analyzedWords.add(new AnalyzedWord(word, 1, positions));
        }
    }

    private boolean addPositionIfWordExists(List<AnalyzedWord> analyzedWords, String word, int position) {
        for (var analyzedWord : analyzedWords) {
            if (analyzedWord.getWord().equals(word)) {
                analyzedWord.setRepetitions(analyzedWord.getRepetitions() + 1);
                analyzedWord.getPositions().add(position);
                return true;
            }
        }
        return false;
    }
}
