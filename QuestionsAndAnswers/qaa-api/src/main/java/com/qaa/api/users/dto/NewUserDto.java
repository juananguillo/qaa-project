package com.qaa.api.users.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewUserDto {
    @NotNull
    @NotEmpty
    private String username;

    @NotNull
    @NotEmpty
    private String email;

    @NotNull
    @NotEmpty
    private String pwd;

    @NotNull
    @NotEmpty
    private String repeatedpwd;
    
    @NotNull
    @NotEmpty
    private int age;

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String surname;

    @NotNull
    @NotEmpty
    private String description;
}
