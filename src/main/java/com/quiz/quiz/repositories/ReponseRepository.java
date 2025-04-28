package com.quiz.quiz.repositories;

import com.quiz.quiz.models.Reponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReponseRepository extends JpaRepository<Reponse, Long> {
    // Tu peux ajouter des méthodes personnalisées si nécessaire
}
