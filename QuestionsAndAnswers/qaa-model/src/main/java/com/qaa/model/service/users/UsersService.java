package com.qaa.model.service.users;

import com.qaa.api.users.dto.UserDto;

import java.util.List;

public interface UsersService {
    
    List<UserDto> findAll();
    
    
    void save(UserDto user);
    
    void delete(Long id);

    void update(UserDto user);
    
}
