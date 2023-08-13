package com.bloggingapplicationspringboot.services.impl;

import com.bloggingapplicationspringboot.entities.Categories;
import com.bloggingapplicationspringboot.exceptions.ResourceNotFoundException;
import com.bloggingapplicationspringboot.payloads.CategoryDto;
import com.bloggingapplicationspringboot.repositories.CategoryRepo;
import com.bloggingapplicationspringboot.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
    public CategoryDto updateCategory(CategoryDto categoryDto, UUID categoryId) {
        Categories findCategory = (Categories) this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category "," category Id ", categoryId));
        findCategory.setTitle(categoryDto.getTitle());
        findCategory.setDesc(categoryDto.getDesc());

        Categories updatedCategory = this.categoryRepo.save(findCategory);

        return this.categoriesToDto(updatedCategory);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Categories> categories = this.categoryRepo.findAll();
        List<CategoryDto> categoryDtoList = categories.stream()
                .map(categories1 -> (this.categoriesToDto(categories1)))
                .collect(Collectors.toList());
        return categoryDtoList;
    }

    @Override
    public CategoryDto getAllCategoriesById(UUID categoryId) {
        Categories findCategory = (Categories) this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category "," category Id ", categoryId));
        return this.categoriesToDto(findCategory);
    }

    @Override
    public void deleteCategory(UUID categoryId) {
        Categories findCategory = (Categories) this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category ", " category Id ", categoryId));
        this.categoryRepo.delete(findCategory);
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
