package com.qaa.api.questions.dto;

import java.util.List;

import com.qaa.api.questions.vo.QuestionsVo;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoundsDto {
  
  private String id;
  
  @NotNull
  @NotEmpty
  private String name;
  

  @NotNull
  @NotEmpty
  private String userId;

}
