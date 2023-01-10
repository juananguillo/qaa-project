package com.qaa.api.answers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerDto {
  private Long id;

  private String answer;

  private String note;
}
