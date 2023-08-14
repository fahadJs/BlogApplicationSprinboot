package com.bloggingapplicationspringboot.payloads;

import com.bloggingapplicationspringboot.entities.Categories;
import com.bloggingapplicationspringboot.entities.Users;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {

    private Integer id;

    @NotEmpty
    private String title;

    @NotEmpty
    private String content;

    private String imagePath;

    private Date dateCreated;

    private Categories category;

    private Users user;
}
