package com.qaa.model.service.users;

import com.qaa.api.users.dto.UsersDto;
import com.qaa.api.users.vo.UserVo;

import java.util.List;

public interface UsersService {
    
    List<UsersDto> findAll();
    
    
    void save(UsersDto user);
    
    void delete(Long id);

    void update(UsersDto user);
    
}
