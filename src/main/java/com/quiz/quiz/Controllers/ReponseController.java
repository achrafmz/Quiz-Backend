package com.quiz.quiz.controllers;

import com.quiz.quiz.models.Reponse;
import com.quiz.quiz.services.ReponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reponses")
public class ReponseController {

    @Autowired
    private ReponseService reponseService;

    // Créer une réponse
    @PostMapping
    public Reponse createReponse(@RequestBody Reponse reponse) {
        return reponseService.createReponse(reponse);
    }

    // Obtenir les réponses d'une question par son ID
    @GetMapping("/question/{questionId}")
    public List<Reponse> getReponsesByQuestionId(@PathVariable Long questionId) {
        return reponseService.getReponsesByQuestionId(questionId);
    }

    // Supprimer une réponse
    @DeleteMapping("/{id}")
    public void deleteReponse(@PathVariable Long id) {
        reponseService.deleteReponse(id);
    }
}
