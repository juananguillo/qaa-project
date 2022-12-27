package com.qaa.api.questions.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Table(name = "question")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionsVo {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO   )
  private Long id;

  private String question;
  
  
  private Long RoundId;
  

  
  
}

