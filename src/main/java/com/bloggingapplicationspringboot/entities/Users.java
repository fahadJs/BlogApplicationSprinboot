package com.bloggingapplicationspringboot.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tbl_users")
@NoArgsConstructor
@Getter
@Setter
public class Users {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_name", nullable = false, length = 100)
    private String name;
    @Column(name = "user_email", nullable = false, length = 100)
    private String email;
    @Column(name = "user_pass", nullable = false, length = 100)
    private String password;
    @Column(name = "user_about", nullable = false, length = 500)
    private String about;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<Posts> postsList;
}
