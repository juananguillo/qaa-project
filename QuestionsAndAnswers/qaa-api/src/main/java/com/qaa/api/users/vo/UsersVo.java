package com.qaa.api.users.vo;

import com.qaa.api.questions.vo.RoundsVo;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Data
@Document(value = "users")
@NoArgsConstructor
@AllArgsConstructor
public class UsersVo {
    
    @Id
    private ObjectId id;
    
    @NotNull
    @NotEmpty
    private String userName;

    @NotNull
    @NotEmpty
    private String pwd;
    
    private String name;
    
    private String surname;
    
    private String description;

    @DocumentReference(lookup="{'userId':?#{#self._id} }")
    private List<RoundsVo> rounds;
    
    
    
    
}
