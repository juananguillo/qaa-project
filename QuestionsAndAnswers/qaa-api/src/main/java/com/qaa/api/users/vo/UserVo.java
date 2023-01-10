package com.qaa.api.users.vo;

import com.qaa.api.questions.vo.RoundQuestionVo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
@ToString(exclude = {"rounds"})
public class UserVo implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @NotEmpty
    private String userName;
    
    private String name;
    
    private String surname;
    
    private String description;
    
    private int age;
    
    @OneToMany(mappedBy ="id", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<RoundQuestionVo> rounds;
    
    
}
