package com.quiz.quiz.services;

import com.quiz.quiz.models.Categorie;
import com.quiz.quiz.repositories.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieService {

    @Autowired
    private CategorieRepository categorieRepository;

    // Récupérer toutes les catégories
    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }

    // Récupérer une catégorie par son ID
    public Optional<Categorie> getCategorieById(Long id) {
        return categorieRepository.findById(id);
    }

    // Créer une nouvelle catégorie
    public Categorie createCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    // Mettre à jour une catégorie existante
    public Optional<Categorie> updateCategorie(Long id, Categorie categorieDetails) {
        Optional<Categorie> existingCategorie = categorieRepository.findById(id);
        if (existingCategorie.isPresent()) {
            Categorie categorie = existingCategorie.get();
            categorie.setNom(categorieDetails.getNom());
            categorie.setDescription(categorieDetails.getDescription());
            categorie.setImage(categorieDetails.getImage());
            categorie.setQuizzes(categorieDetails.getQuizzes());
            return Optional.of(categorieRepository.save(categorie));
        }
        return Optional.empty();
    }

    // Supprimer une catégorie
    public boolean deleteCategorie(Long id) {
        Optional<Categorie> categorie = categorieRepository.findById(id);
        if (categorie.isPresent()) {
            categorieRepository.delete(categorie.get());
            return true;
        }
        return false;
    }
}
