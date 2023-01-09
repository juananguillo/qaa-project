package com.qaa.model.service.users.impl;

import com.qaa.api.users.dto.UserDto;
import com.qaa.model.mapper.users.UserMap;
import com.qaa.model.repository.users.UserDao;
import com.qaa.model.service.users.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl  implements UsersService {
    
    @Autowired
    UserDao dao;
    
    @Autowired
    UserMap map;
    
    @Override
    public List<UserDto> findAll() {
        return map.asDTos(dao.findAll());
    }

   

    @Override
    public void save(UserDto user) {
        dao.save(map.asVo(user));
    }

    @Override
    public void delete(Long id) {
        dao.deleteById(id);
    }

    @Override
    public void update(UserDto user) {
      dao.update(user.getId(), user.getName(), user.getSurname(), user.getDescription(), user.getAge());
    }
}
