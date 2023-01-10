package com.example.TextAnalyzer.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.List;
import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AnalyzedWord {

    @Id
    private String word;
    private int repetitions;
    @ElementCollection
    private List<Integer> positions;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AnalyzedWord that)) return false;
        return repetitions == that.repetitions
                && Objects.equals(word, that.word)
                && Objects.equals(positions, that.positions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, repetitions, positions);
    }
}
