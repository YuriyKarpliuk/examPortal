package com.exam.controller;

import com.exam.entity.Question;
import com.exam.entity.Quiz;
import com.exam.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
        return ResponseEntity.ok(this.questionService.addQuestion(question));
    }

    @GetMapping("/{questionId}")
    public Optional<Question> getQuiz(@PathVariable("questionId") Long questionId) {
        return this.questionService.getQuestionById(questionId);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getQuestions() {
        return ResponseEntity.ok(this.questionService.getQuestions());
    }

    @GetMapping("/quiz/{quizId}")
    public ResponseEntity<?> getQuestionsByQuiz(@PathVariable("quizId") Long quizId) {
        return ResponseEntity.ok(new ArrayList<>(this.questionService.getQuestionsByQuizId(quizId)));
    }

    @GetMapping("/quiz/all/{quizId}")
    public ResponseEntity<?> getQuestionsByQuizAdmin(@PathVariable("quizId") Long quizId) {
        return ResponseEntity.ok(new ArrayList<>(this.questionService.getQuestionsByQuizId(quizId)));
    }

    @PutMapping("/")
    public Question updateQuestion(@RequestBody Question question) {
        return this.questionService.updateQuestion(question);
    }

    @DeleteMapping("/{questionId}")
    public void deleteQuestion(@PathVariable("questionId") Long questionId) {
        this.questionService.deleteQuestionById(questionId);
    }

    @PostMapping("/eval-quiz")
    public ResponseEntity<?> evalQuiz(@RequestBody List<Question> questions) {
        return ResponseEntity.ok(questionService.evaluateQuiz(questions));
    }
}
