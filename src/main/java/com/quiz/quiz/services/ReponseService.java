package com.quiz.quiz.services;

import com.quiz.quiz.models.Reponse;
import com.quiz.quiz.repositories.ReponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReponseService {

    @Autowired
    private ReponseRepository reponseRepository;

    // Créer une réponse
    public Reponse createReponse(Reponse reponse) {
        return reponseRepository.save(reponse);
    }

    // Trouver une réponse par son ID
    public Optional<Reponse> getReponseById(Long id) {
        return reponseRepository.findById(id);
    }

    // Trouver toutes les réponses d'une question
    public List<Reponse> getReponsesByQuestionId(Long questionId) {
        return reponseRepository.findAll().stream()
                .filter(reponse -> reponse.getQuestion().getId().equals(questionId))
                .toList();
    }

    // Supprimer une réponse
    public void deleteReponse(Long id) {
        reponseRepository.deleteById(id);
    }
}
