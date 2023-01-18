package com.qaa.api.users.userRol;

import com.qaa.api.users.roles.RoleVo;
import com.qaa.api.users.vo.UserVo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usersRoles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRolVo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private UserVo user;

    @ManyToOne
    private RoleVo role;
}
