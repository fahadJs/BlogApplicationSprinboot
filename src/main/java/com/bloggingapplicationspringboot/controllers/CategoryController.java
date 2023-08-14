package com.bloggingapplicationspringboot.controllers;


import com.bloggingapplicationspringboot.payloads.ApiResponse;
import com.bloggingapplicationspringboot.payloads.CategoryDto;
import com.bloggingapplicationspringboot.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //    POST REQUEST
    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
        CategoryDto createCategory = this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(createCategory, HttpStatus.CREATED);
    }

    //    PUT REQUEST
    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable Integer categoryId){
        CategoryDto updateCategory = this.categoryService.updateCategory(categoryDto, categoryId);
        return new ResponseEntity<>(updateCategory, HttpStatus.OK);
    }

    //    GET ALL CATEGORIES
    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getAllCategories(){
        List<CategoryDto> allCategories = this.categoryService.getAllCategories();
        return new ResponseEntity<>(allCategories, HttpStatus.OK);
    }
    //    GET CATEGORIES BY ID
    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getCategoriesById(@PathVariable Integer categoryId){
        CategoryDto categoriesById = this.categoryService.getAllCategoriesById(categoryId);
        return new ResponseEntity<>(categoriesById, HttpStatus.OK);
    }

    //    DELETE CATEGORY REQUEST
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer categoryId){
        this.categoryService.deleteCategory(categoryId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Category deleted successfully!",true), HttpStatus.OK);
    }
}
