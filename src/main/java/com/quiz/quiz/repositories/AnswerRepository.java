package com.quiz.quiz.repositories;

import com.quiz.quiz.models.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
