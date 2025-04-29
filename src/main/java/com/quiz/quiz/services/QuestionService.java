package com.quiz.quiz.services;

import com.quiz.quiz.models.Question;
import com.quiz.quiz.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }
    public Question updateQuestion(Long id, Question updatedQuestion) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question non trouvée avec l'id : " + id));

        question.setEnonce(updatedQuestion.getEnonce());
        question.setType(updatedQuestion.getType());
        question.setPoints(updatedQuestion.getPoints());
        question.setExplication(updatedQuestion.getExplication());
        question.setQuiz(updatedQuestion.getQuiz());

        return questionRepository.save(question);
    }
    public Optional<Question> getQuestionById(Long id) {
        return questionRepository.findById(id);
    }

    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }

    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }
}