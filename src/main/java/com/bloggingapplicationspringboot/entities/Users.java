package com.bloggingapplicationspringboot.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_users")
@NoArgsConstructor
@Getter
@Setter
public class Users {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Column(name = "user_email", nullable = false, length = 100)
    private String email;
    @Column(name = "user_pass", nullable = false, length = 100)
    private String password;
    @Column(name = "user_about", nullable = false, length = 500)
    private String about;

//    Added Comment for TESTING!
}
