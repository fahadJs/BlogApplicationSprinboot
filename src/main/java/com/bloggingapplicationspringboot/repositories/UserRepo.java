package com.bloggingapplicationspringboot.repositories;

import com.bloggingapplicationspringboot.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users, Integer> {

}
