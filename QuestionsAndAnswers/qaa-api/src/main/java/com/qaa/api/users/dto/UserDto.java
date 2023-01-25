package com.qaa.api.users.dto;

import com.qaa.api.questions.dto.RoundQuestionDto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;
   
    private String username;

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String surname;


    private String mail;

    @NotNull
    @NotEmpty
    private String description;

    @NotNull
    @NotEmpty
    private int age;

    private List<RoundQuestionDto> rounds;


}
