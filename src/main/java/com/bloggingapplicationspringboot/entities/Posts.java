package com.bloggingapplicationspringboot.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "tbl_posts")
@Getter
@Setter
@NoArgsConstructor
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Integer id;
    @Column(name = "post_title", nullable = false, length = 500)
    private String title;
    @Column(name = "post_content", nullable = false, length = 10000)
    private String content;
    @Column(name = "post_date_created", nullable = false)
    private Date dateCreated;
    @Column(name = "post_image", nullable = false)
    private String imagePath;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Categories categories;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private Users users;
}
