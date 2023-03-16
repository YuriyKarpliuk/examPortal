package com.exam.service.impl;

import com.exam.entity.Question;
import com.exam.repository.QuestionRepository;
import com.exam.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question addQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Set<Question> getQuestions() {
        return new HashSet<>( this.questionRepository.findAll());
    }

    @Override
    public Set<Question> getQuestionsByQuizId(Long quizId) {
        return this.questionRepository.findByQuizId(quizId);
    }

    @Override
    public Optional<Question> getQuestionById(Long id) {
        return this.questionRepository.findById(id);
    }

    @Override
    public void deleteQuestionById(Long id) {
        Question question = new Question();
        question.setId(id);
        this.questionRepository.delete(question);
    }

    @Override
    public Optional<Question> getById(Long questionId) {
        return questionRepository.findById(questionId);
    }
    @Override
    public Map<String,Object> evaluateQuiz(List<Question> questions) {
        Double marksGot = 0.0;
        Integer correctAnswers = 0;
        Integer attempted = 0;
        for (Question q : questions) {
            Optional<Question> question = getById(q.getId());
            if (question.get().getAnswer().trim().equals(q.getGivenAnswer())) {
                correctAnswers++;
                Double markSingle = Double.parseDouble(questions.get(0).getQuiz().getMaxMarks()) / questions.size();
                marksGot += markSingle;
            }
            if (q.getGivenAnswer() != null) {
                attempted++;
            }
        }

        return  Map.of("marksGot", marksGot, "correctAnswers", correctAnswers, "attempted", attempted);
    }

}
