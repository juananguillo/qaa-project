package com.qaa.model.service.users;

import com.qaa.api.users.dto.UsersDto;

import java.util.List;

public interface UsersService {
    
    List<UsersDto> findAll();
    
    UsersDto findById(String id);
    
    void save(UsersDto user);
    
    void delete(String id);
    
    void update(UsersDto user);
    
}
