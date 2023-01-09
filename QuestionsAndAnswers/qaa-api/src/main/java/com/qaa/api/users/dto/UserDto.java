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
    
    private String userName;
    
    private String name;

    private String surname;

    private String description;
    
    private int age;

    private List<RoundQuestionDto> rounds;


}
