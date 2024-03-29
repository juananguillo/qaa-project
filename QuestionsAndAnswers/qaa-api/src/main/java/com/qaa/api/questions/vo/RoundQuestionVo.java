package com.qaa.api.questions.vo;

import com.qaa.api.answers.vo.RoundAnswerVo;
import com.qaa.api.users.vo.UserVo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="questionsrounds")
public class RoundQuestionVo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY   )
    private Long id;
    
    @NotNull
    @NotEmpty
    private String name;
    
    @NotNull
    @NotEmpty
    private String description;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private UserVo user;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "round_id")
    private List<QuestionVo> questions;

    @OneToMany(mappedBy ="id", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<RoundAnswerVo> answers;
    
}
