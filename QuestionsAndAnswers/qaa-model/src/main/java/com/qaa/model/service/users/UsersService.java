package com.qaa.model.service.users;

import com.qaa.api.users.dto.NewUserDto;
import com.qaa.api.users.dto.PwdDto;
import com.qaa.api.users.dto.UserDto;
import com.qaa.api.users.dto.UserLogDto;
import com.qaa.api.users.vo.UserVo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UsersService extends UserDetailsService {
    
    List<UserDto> findAll();
    
    
    void save(NewUserDto user) throws Exception;
    
    void delete(Long id);

    void updateInfo(UserDto user);
    
    UserVo verify(UserLogDto user);

    boolean existMail(String mail);

    boolean existUsername(String username);
    
    void updatePwd(PwdDto user) throws Exception;
    
}
