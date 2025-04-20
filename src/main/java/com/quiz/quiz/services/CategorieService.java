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

    // Create a new category
    public Categorie createCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    // Get all categories
    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }

    // Get a category by ID
    public Optional<Categorie> getCategorieById(Long id) {
        return categorieRepository.findById(id);
    }

    // Update an existing category
    public Categorie updateCategorie(Long id, Categorie updatedCategorie) {
        return categorieRepository.findById(id).map(categorie -> {
            categorie.setNom(updatedCategorie.getNom());
            categorie.setDescription(updatedCategorie.getDescription());
            categorie.setImage(updatedCategorie.getImage());
            return categorieRepository.save(categorie);
        }).orElseThrow(() -> new RuntimeException("Category not found with id " + id));
    }

    // Delete a category by ID
    public void deleteCategorie(Long id) {
        categorieRepository.deleteById(id);
    }
}