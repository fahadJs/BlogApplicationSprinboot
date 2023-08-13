package com.bloggingapplicationspringboot.repositories;

import com.bloggingapplicationspringboot.entities.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Categories, Integer> {
}
