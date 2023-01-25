package com.qaa.api.users.vo;

import com.qaa.api.questions.vo.RoundQuestionVo;
import com.qaa.api.users.roles.RoleVo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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

    @NotNull
    @NotEmpty
    private String pwd;

    @NotNull
    @NotEmpty
    @Column(unique=true)
    private String mail;
    
    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String surname;
    
    @NotNull
    @NotEmpty
    private String description;
    
    @NotNull
    @NotEmpty
    private int age;
    
    private int state;
    
    @OneToMany(mappedBy ="id", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<RoundQuestionVo> rounds;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<RoleVo> userRoles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> auth = new ArrayList<>();
        this.userRoles.forEach(userRol ->{
            auth.add(new SimpleGrantedAuthority("ROLE_" +userRol.getRolName()));
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
