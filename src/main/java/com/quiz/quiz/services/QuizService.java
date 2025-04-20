package com.quiz.quiz.services;

import com.quiz.quiz.models.Quiz;
import com.quiz.quiz.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    // Create a new quiz
    public Quiz createQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    // Get all quizzes
    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    // Get a quiz by ID
    public Optional<Quiz> getQuizById(Long id) {
        return quizRepository.findById(id);
    }

    // Update an existing quiz
    public Quiz updateQuiz(Long id, Quiz updatedQuiz) {
        return quizRepository.findById(id).map(quiz -> {
            quiz.setQuiz_name(updatedQuiz.getQuiz_name());
            quiz.setDescription(updatedQuiz.getDescription());
            quiz.setDifficulty(updatedQuiz.getDifficulty());
            quiz.setQuestions(updatedQuiz.getQuestions());
            quiz.setResults(updatedQuiz.getResults());
            quiz.setCategorie(updatedQuiz.getCategorie());
            return quizRepository.save(quiz);
        }).orElseThrow(() -> new RuntimeException("Quiz not found with id " + id));
    }

    // Delete a quiz by ID
    public void deleteQuiz(Long id) {
        quizRepository.deleteById(id);
    }
}