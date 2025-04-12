package com.quiz.quiz.models;

import jakarta.persistence.*;

@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answer_id;

    private boolean correct_answer;
    private String text;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;


    public Answer() {}
    public Answer(String text, boolean correct_answer, Question question) {
        this.text = text;
        this.correct_answer = correct_answer;
        this.question = question;
    }

    // Getters et setters

    public Long getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(Long answer_id) {
        this.answer_id = answer_id;
    }

    public boolean isCorrect_answer() {
        return correct_answer;
    }

    public void setCorrect_answer(boolean correct_answer) {
        this.correct_answer = correct_answer;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
