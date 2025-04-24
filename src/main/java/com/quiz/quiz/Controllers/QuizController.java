package com.quiz.quiz.Controllers;

import com.quiz.quiz.models.Quiz;
import com.quiz.quiz.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quizzes")
@CrossOrigin("*")
public class QuizController {
    @Autowired
    private QuizService quizService;

    @GetMapping
    public List<Quiz> getAll() {
        return quizService.findAll();
    }

    @PostMapping
    public Quiz create(@RequestBody Quiz quiz) {
        return quizService.save(quiz);
    }

    @PutMapping("/{id}")
    public Quiz update(@PathVariable Long id, @RequestBody Quiz quiz) {
        return quizService.update(id, quiz);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        quizService.delete(id);
    }
}
