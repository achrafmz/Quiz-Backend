package com.quiz.quiz.repositories;

import com.quiz.quiz.models.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
