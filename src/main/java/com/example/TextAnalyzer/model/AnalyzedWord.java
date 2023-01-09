package com.example.TextAnalyzer.model;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class AnalyzedWord {

    private String word;
    private int repetitions;
    private List<Integer> positions;
}
