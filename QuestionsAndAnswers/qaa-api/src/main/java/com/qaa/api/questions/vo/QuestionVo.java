package com.qaa.api.questions.vo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "question")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionVo implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY   )
  private Long id;

  @NotNull
  @NotEmpty
  private String question;
  
  private int size;
  
  private String clue;
  
  
  private boolean optional;
  

  

  
  
}

