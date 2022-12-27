package com.qaa.model.repository.users;

import com.qaa.api.users.vo.UsersVo;

import java.util.List;

public interface UsersDao {
    
    List<UsersVo> findAll();
    
    UsersVo findById(String id);
    
    void save(UsersVo user);
    
    void delete(String id);
    
    void update(UsersVo user);
}
