package com.qaa.api.answers.vo;

import java.util.List;

import com.qaa.api.questions.vo.RoundQuestionVo;
import com.qaa.api.users.vo.UserVo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="answersround")
public class RoundAnswerVo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  private int match;

  @NotNull
  @ManyToOne(fetch = FetchType.LAZY)
  private UserVo user;

  @NotNull
  @ManyToOne(fetch = FetchType.LAZY)
  private RoundQuestionVo round;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "round_id")
  private List<AnswerVo> answers;
  
}
