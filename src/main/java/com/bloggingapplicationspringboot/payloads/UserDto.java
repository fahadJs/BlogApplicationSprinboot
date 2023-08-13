package com.bloggingapplicationspringboot.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private UUID id;

    @NotEmpty
    private String name;

    @Email(message = "Enter a Valid Email Address!")
    private String email;

    @NotEmpty
    @Size(min = 8, message = "Password should be 8 characters or more!")
    private String password;

    @NotEmpty
    private String about;

}
