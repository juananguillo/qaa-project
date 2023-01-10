package com.qaa.api.answers.dto;

import java.util.List;

import com.qaa.api.answers.vo.AnswerVo;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoundAnswerDto {

  private Long id;

  private int like;
  
  @NotNull
  private Long userId;
  
  @NotNull
  private Long roundId;

  @NotNull
  private List<AnswerDto> answers;
  
}
