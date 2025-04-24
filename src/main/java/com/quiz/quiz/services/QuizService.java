package com.quiz.quiz.services;

import com.quiz.quiz.models.Quiz;
import com.quiz.quiz.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
    @Autowired
    private QuizRepository quizRepository;

    public List<Quiz> findAll() {
        return quizRepository.findAll();
    }

    public Quiz findById(Long id) {
        return quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz introuvable"));
    }

    public Quiz save(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    public Quiz update(Long id, Quiz quizDetails) {
        Quiz quiz = findById(id);
        quiz.setNom(quizDetails.getNom());
        quiz.setDescription(quizDetails.getDescription());
        quiz.setDifficulte(quizDetails.getDifficulte());
        quiz.setCategorie(quizDetails.getCategorie());
        return quizRepository.save(quiz);
    }

    public void delete(Long id) {
        quizRepository.deleteById(id);
    }
}
