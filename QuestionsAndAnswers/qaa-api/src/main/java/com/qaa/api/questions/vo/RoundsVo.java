package com.qaa.api.questions.vo;

import com.qaa.api.users.vo.UsersVo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="rounds")
public class RoundsVo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO   )
    private Long id;
    
    @NotNull
    @NotEmpty
    private String name;
    
    
   @NotNull
   @NotEmpty
   
    private String userId;
    
    
}
