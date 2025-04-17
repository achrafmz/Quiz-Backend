package com.quiz.quiz.repositories;

import com.quiz.quiz.models.QuizResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizResultRepository extends JpaRepository<QuizResult, Long> {
}
