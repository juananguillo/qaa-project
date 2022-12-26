package com.qaa.api.questions.vo;

import com.qaa.api.users.vo.UsersVo;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "rounds")
public class RoundsVo {
    @Id
    private ObjectId id;
    
    @NotNull
    @NotEmpty
    private String name;

    @ReadOnlyProperty
    @DocumentReference(lazy=true)
    private List <QuestionsVo> questions;
    
    
}
