package com.qaa.api.users.dto;

import com.qaa.api.questions.dto.RoundDto;
import com.qaa.api.questions.vo.RoundVo;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersDto {

    private Long id;
    
    @NotNull
    @NotEmpty
    private String userName;

    @NotNull
    @NotEmpty
    private String pwd;

    private String name;

    private String surname;

    private String description;
    
    private int age;

    private List<RoundDto> rounds;


}
