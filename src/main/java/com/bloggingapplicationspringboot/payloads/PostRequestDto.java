package com.bloggingapplicationspringboot.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PostRequestDto {
    private String title;

    private String content;

    private String imagePath;

    private Date dateCreated;

    private Integer category;

    private Integer user;
}
