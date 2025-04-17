package com.quiz.quiz.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Participant extends Utilisateur {

    private double scoreTotal;
    private int nbrQuizComplet;

    @OneToMany(mappedBy = "participant", cascade = CascadeType.ALL)
    private List<QuizResult> results;

    // Getters & setters

    public double getScoreTotal() {
        return scoreTotal;
    }

    public void setScoreTotal(double scoreTotal) {
        this.scoreTotal = scoreTotal;
    }

    public List<QuizResult> getResults() {
        return results;
    }

    public void setResults(List<QuizResult> results) {
        this.results = results;
    }

    public int getNbrQuizComplet() {
        return nbrQuizComplet;
    }

    public void setNbrQuizComplet(int nbrQuizComplet) {
        this.nbrQuizComplet = nbrQuizComplet;
    }
}
