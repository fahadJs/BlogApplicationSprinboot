package com.bloggingapplicationspringboot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tbl_categories")
@Getter
@Setter
@NoArgsConstructor
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer id;
    @Column(name = "category_title", nullable = false, length = 50)
    private String title;
    @Column(name = "category_desc", nullable = false, length = 500)
    private String desc;

    @JsonIgnore
    @OneToMany(mappedBy = "categories", cascade = CascadeType.ALL)
    private List<Posts> postsList;
}
