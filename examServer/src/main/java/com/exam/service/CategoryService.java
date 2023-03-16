package com.exam.service;

import com.exam.entity.Category;

import java.util.Optional;
import java.util.Set;

public interface CategoryService {

    Category addCategory(Category category);

    Category updateCategory(Category category);
    void deleteCategoryById(Long categoryId);

    Set<Category> getCategories();

    Optional<Category> getCategoryById(Long categoryId);
}
