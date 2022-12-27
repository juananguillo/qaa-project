package com.qaa.api.users.dto;

import com.qaa.api.questions.dto.RoundsDto;
import com.qaa.api.questions.vo.RoundsVo;
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

    private String id;
    
    @NotNull
    @NotEmpty
    private String userName;

    @NotNull
    @NotEmpty
    private String pwd;

    private String name;

    private String surname;

    private String description;

    private List<RoundsDto> rounds;
}
