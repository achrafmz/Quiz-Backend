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

    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    public Optional<Quiz> getQuizById(Long id) {
        return quizRepository.findById(id);
    }

    public Quiz createQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    public Optional<Quiz> updateQuiz(Long id, Quiz quizDetails) {
        return quizRepository.findById(id).map(quiz -> {
            quiz.setQuiz_name(quizDetails.getQuiz_name());
            quiz.setDescription(quizDetails.getDescription());
            quiz.setDifficulty(quizDetails.getDifficulty());
            quiz.setQuestions(quizDetails.getQuestions());
            return quizRepository.save(quiz);
        });
    }

    public boolean deleteQuiz(Long id) {
        if (quizRepository.existsById(id)) {
            quizRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
