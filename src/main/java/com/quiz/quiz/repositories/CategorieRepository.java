package com.quiz.quiz.repositories;

import com.quiz.quiz.models.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
}
