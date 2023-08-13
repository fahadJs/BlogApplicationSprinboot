package com.bloggingapplicationspringboot.services;
import com.bloggingapplicationspringboot.payloads.CategoryDto;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;
import java.util.UUID;

public interface CategoryService {

    CategoryDto createCategory(CategoryDto categoryDto);
    CategoryDto updateCategory(CategoryDto categoryDto, UUID categoryId);
    List<CategoryDto> getAllCategories();
    CategoryDto getAllCategoriesById(UUID categoryId);
    void deleteCategory(UUID categoryId);

}
