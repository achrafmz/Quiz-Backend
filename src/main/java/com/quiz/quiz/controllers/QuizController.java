package com.quiz.quiz.controllers;

import com.quiz.quiz.models.Quiz;
import com.quiz.quiz.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    private static final Logger logger = LoggerFactory.getLogger(QuizController.class);

    //  Get All
    @GetMapping
    public List<Quiz> getAllQuizzes() {
        return quizService.getAllQuizzes();
    }

    //  Get One
    @GetMapping("/{id}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable Long id) {
        return quizService.getQuizById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //  Create
    @PostMapping
    public ResponseEntity<Quiz> createQuiz(@RequestBody Quiz quiz) {
        try {
            if (quiz.getCategorie() == null || quiz.getCategorie().getId() == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
            Quiz createdQuiz = quizService.createQuiz(quiz);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdQuiz);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    //  Update
    @PutMapping("update/{id}")
    public ResponseEntity<Quiz> updateQuiz(@PathVariable Long id, @RequestBody Quiz quizDetails) {
        return quizService.updateQuiz(id, quizDetails)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //  Delete
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteQuiz(@PathVariable Long id) {
        if (quizService.deleteQuiz(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
