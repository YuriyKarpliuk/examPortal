package com.exam.service.impl;

import com.exam.entity.Quiz;
import com.exam.repository.QuizRepository;
import com.exam.service.QuizService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
@Service
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;

    public QuizServiceImpl(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Override
    public Quiz addQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public Set<Quiz> getQuizzes() {
        return new HashSet<>(this.quizRepository.findAll());
    }

    @Override
    public Optional<Quiz> getQuizById(Long id) {
        return this.quizRepository.findById(id);
    }

    @Override
    public void deleteQuizById(Long id) {
        this.quizRepository.deleteById(id);
    }

    @Override
    public List<Quiz> getQuizzesByCategory(Long categoryId) {
        return quizRepository.findQuizzesByCategoryId(categoryId);
    }

    @Override
    public List<Quiz> getQuizzesByActive() {
        return quizRepository.findQuizzesByActive(true);
    }

    @Override
    public List<Quiz> getQuizzesByActiveAndCategoryId(Long categoryId) {
        return quizRepository.findQuizzesByActiveAndCategoryId(true,categoryId);
    }
}
