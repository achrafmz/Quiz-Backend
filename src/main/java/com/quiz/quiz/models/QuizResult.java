package com.quiz.quiz.models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class QuizResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long result_id;

    private double score;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private int duree; // en secondes ou minutes

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @ManyToOne
    @JoinColumn(name = "participant_id")
    private Participant participant;

    // Getters & Setters

    public Long getResult_id() {
        return result_id;
    }

    public void setResult_id(Long result_id) {
        this.result_id = result_id;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }
}
