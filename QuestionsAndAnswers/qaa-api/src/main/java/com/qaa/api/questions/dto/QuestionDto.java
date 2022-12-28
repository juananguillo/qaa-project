package com.qaa.api.questions.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDto {

  private Long id;

  // @NotNull(message = ErrorConstants.titleError)
  @NotEmpty
  private String question;
  
  private int min;
  
  private RoundDto round;
}
  
    