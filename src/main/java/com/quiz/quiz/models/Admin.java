package com.quiz.quiz.models;

import jakarta.persistence.Entity;

@Entity
public class Admin extends Utilisateur {

    private int nbrQuizCreate;

    // Getters & setters

    public int getNbrQuizCreate() {
        return nbrQuizCreate;
    }

    public void setNbrQuizCreate(int nbrQuizCreate) {
        this.nbrQuizCreate = nbrQuizCreate;
    }
}
