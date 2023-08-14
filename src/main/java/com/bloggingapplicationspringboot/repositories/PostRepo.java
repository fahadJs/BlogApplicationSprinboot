package com.bloggingapplicationspringboot.repositories;

import com.bloggingapplicationspringboot.entities.Categories;
import com.bloggingapplicationspringboot.entities.Posts;
import com.bloggingapplicationspringboot.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PostRepo extends JpaRepository<Posts, Integer> {

    List<Posts> findByUser(Users users);
    List<Posts> findByCategory(Categories categories);
}
