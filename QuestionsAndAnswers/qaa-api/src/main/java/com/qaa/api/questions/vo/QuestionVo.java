package com.qaa.api.questions.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "question")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionVo {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO   )
  private Long id;

  private String question;
  
  
  private int min;
  
  @ManyToOne
  @JoinColumn(name = "round_id")
  private RoundVo round;
  

  
  
}

