package com.bloggingapplicationspringboot.services;
import com.bloggingapplicationspringboot.payloads.CategoryDto;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;
import java.util.UUID;

public interface CategoryService {

    CategoryDto createCategory(CategoryDto categoryDto);
    CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
    List<CategoryDto> getAllCategories();
    CategoryDto getAllCategoriesById(Integer categoryId);
    void deleteCategory(Integer categoryId);

}
