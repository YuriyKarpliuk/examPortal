package com.exam.repository;

import com.exam.entity.Question;
import com.exam.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;


public interface QuestionRepository extends JpaRepository<Question,Long> {

    Set<Question> findByQuizId(Long quizId);
}
