package com.exam.repository;

import com.exam.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz,Long> {

    List<Quiz> findQuizzesByCategoryId(Long categoryId);
    List<Quiz> findQuizzesByActive(Boolean active);
    List<Quiz> findQuizzesByActiveAndCategoryId(Boolean active,Long categoryId);


}
