package com.bloggingapplicationspringboot.services.impl;

import com.bloggingapplicationspringboot.entities.Categories;
import com.bloggingapplicationspringboot.payloads.CategoryDto;
import com.bloggingapplicationspringboot.repositories.CategoryRepo;
import com.bloggingapplicationspringboot.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Categories categories = this.dtoToCategories(categoryDto);
        Categories savedCategory = this.categoryRepo.save(categories);
        return this.categoriesToDto(savedCategory);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
        return null;
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        return null;
    }

    @Override
    public CategoryDto getAllCategoriesById(Integer categoryId) {
        return null;
    }

    @Override
    public void deleteCategory(Integer categoryId) {

    }

    public Categories dtoToCategories (CategoryDto categoryDto){
        Categories categories = modelMapper.map(categoryDto, Categories.class);
        return categories;
    }

    public CategoryDto categoriesToDto (Categories categories){
        CategoryDto categoryDto = modelMapper.map(categories, CategoryDto.class);
        return categoryDto;
    }
}
