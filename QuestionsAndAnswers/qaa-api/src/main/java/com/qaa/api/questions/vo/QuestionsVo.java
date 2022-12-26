package com.qaa.api.questions.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "questions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionsVo {
  @Id
  private ObjectId id;

  private String question;
  
  @Indexed
  private ObjectId roundsId;
  
  
}

