package com.qaa.api.questions.dto;


import com.qaa.api.users.dto.UsersDto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoundDto {
  
  private Long id;
  
  @NotNull
  @NotEmpty
  private String name;

  @NotNull
  @NotEmpty
  private String description;

  @NotNull
  private Long userid;

  private List<QuestionDto> questions;

}
