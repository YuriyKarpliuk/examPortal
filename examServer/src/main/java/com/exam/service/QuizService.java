package com.exam.service;

import com.exam.entity.Quiz;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface QuizService {

    Quiz addQuiz(Quiz quiz);

    Quiz updateQuiz(Quiz quiz);
    Set<Quiz> getQuizzes();

    Optional<Quiz> getQuizById(Long id);
    void deleteQuizById(Long id);

    List<Quiz> getQuizzesByCategory(Long categoryId);
    List<Quiz> getQuizzesByActive();
    List<Quiz> getQuizzesByActiveAndCategoryId(Long categoryId);
}
