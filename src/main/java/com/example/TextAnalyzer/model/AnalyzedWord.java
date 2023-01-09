package com.example.TextAnalyzer.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class AnalyzedWord {

    private String word;
    private int repetitions;
    private List<Integer> positions;
}
