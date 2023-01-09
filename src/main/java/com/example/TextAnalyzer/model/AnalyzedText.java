package com.example.TextAnalyzer.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class AnalyzedText {

    private List<AnalyzedWord> analyzedWords;
}
