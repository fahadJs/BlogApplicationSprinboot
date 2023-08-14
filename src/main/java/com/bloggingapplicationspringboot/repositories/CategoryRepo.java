package com.bloggingapplicationspringboot.repositories;

import com.bloggingapplicationspringboot.entities.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CategoryRepo extends JpaRepository<Categories, Integer> {

}
