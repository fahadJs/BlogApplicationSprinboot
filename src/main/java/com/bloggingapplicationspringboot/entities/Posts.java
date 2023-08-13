package com.bloggingapplicationspringboot.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "tbl_posts")
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "post_id")
    private UUID id;
    @Column(name = "post_title", nullable = false, length = 500)
    private String title;
    @Column(name = "post_content", nullable = false, length = 10000)
    private String content;
    @Column(name = "post_date_created", nullable = false)
    private Date dateCreated;
    @Column(name = "post_image", nullable = false)
    private String imagePath;

    @ManyToOne
    private Categories categories;
    @ManyToOne
    private Users users;
}
