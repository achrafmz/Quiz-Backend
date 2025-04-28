package com.quiz.quiz.repositories;

import com.quiz.quiz.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    // Vous pouvez ajouter des méthodes personnalisées si nécessaire
}
