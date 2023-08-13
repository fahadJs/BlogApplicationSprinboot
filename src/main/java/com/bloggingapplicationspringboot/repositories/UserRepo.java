package com.bloggingapplicationspringboot.repositories;

import com.bloggingapplicationspringboot.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepo extends JpaRepository<Users, Integer> {

    Optional<Object> findById(UUID userId);
}
