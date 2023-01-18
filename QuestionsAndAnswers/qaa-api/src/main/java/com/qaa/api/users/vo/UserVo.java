package com.qaa.api.users.vo;

import com.qaa.api.questions.vo.RoundQuestionVo;
import com.qaa.api.users.auth.Authority;
import com.qaa.api.users.userRol.UserRolVo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
@ToString(exclude = {"rounds"})
public class UserVo implements UserDetails {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @NotEmpty
    @Column(unique=true)
    private String username;
    
    private String pwd;
    
    private String mail;
    
    private String name;
    
    private String surname;
    
    private String description;
    
    private int age;
    
    @OneToMany(mappedBy ="id", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<RoundQuestionVo> rounds;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "user")
    private List<UserRolVo> userRoles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<Authority> auth = new ArrayList<>();
        this.userRoles.forEach(userRol ->{
            auth.add(new Authority(userRol.getRole().getRolName()));
        });
        return auth;
    }

    @Override
    public String getPassword() {
        return pwd;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    
    
    
}
