package com.exam.controller;

import com.exam.entity.Quiz;
import com.exam.service.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping("/")
    public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz) {
        return ResponseEntity.ok(this.quizService.addQuiz(quiz));
    }

    @GetMapping("/{quizId}")
    public Optional<Quiz> getQuiz(@PathVariable("quizId") Long quiId) {
        return this.quizService.getQuizById(quiId);
    }


    @GetMapping("/category/{categoryId}")
    public ResponseEntity<?> getQuizzesByCategory(@PathVariable("categoryId") Long categoryId) {
        return ResponseEntity.ok(this.quizService.getQuizzesByCategory(categoryId));
    }

    @GetMapping("/active")
    public ResponseEntity<?> getActiveQuizzes() {
        return ResponseEntity.ok(this.quizService.getQuizzesByActive());
    }

    @GetMapping("/category/active/{categoryId}")
    public ResponseEntity<?> getActiveQuizzesByCategoryId(@PathVariable("categoryId") Long categoryId) {
        return ResponseEntity.ok(this.quizService.getQuizzesByActiveAndCategoryId(categoryId));
    }
    @GetMapping("/all")
    public ResponseEntity<?> getQuizzes() {
        return ResponseEntity.ok(this.quizService.getQuizzes());
    }

    @PutMapping("/")
    public Quiz updateQuiz(@RequestBody Quiz quiz){
        return  this.quizService.updateQuiz(quiz);
    }

    @DeleteMapping("/{quizId}")
    public void deleteQuiz(@PathVariable("quizId") Long quizId){
        this.quizService.deleteQuizById(quizId);
    }
}
