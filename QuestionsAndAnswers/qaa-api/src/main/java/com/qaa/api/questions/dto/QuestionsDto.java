package com.qaa.api.questions.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionsDto {

  private String id;

  // @NotNull(message = ErrorConstants.titleError)
  @NotEmpty
  private String question;

  
}
  
    