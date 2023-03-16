package com.exam.service;

import com.exam.entity.Question;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface QuestionService {
    Question addQuestion(Question question);

    Question updateQuestion(Question question);
    Set<Question> getQuestions();

    Set<Question> getQuestionsByQuizId(Long quizId);
    Optional<Question> getQuestionById(Long id);
    void deleteQuestionById(Long id);

    Optional<Question> getById(Long questionId);
    Map<String,Object> evaluateQuiz(List<Question> questions);
}
