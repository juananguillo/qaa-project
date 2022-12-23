package com.qaa.model.service.users.impl;

import com.qaa.api.users.dto.UsersDto;
import com.qaa.model.mapper.users.UsersMap;
import com.qaa.model.repository.users.UsersDao;
import com.qaa.model.service.users.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl  implements UsersService {
    
    @Autowired
    UsersDao dao;
    
    @Autowired
    UsersMap map;
    
    @Override
    public List<UsersDto> findAll() {
        return map.asDTos(dao.findAll());
    }

    @Override
    public UsersDto findById(String id) {
        return map.asDTo(dao.findById(id));
    }

    @Override
    public void save(UsersDto user) {
        dao.save(map.asVo(user));
    }

    @Override
    public void delete(String id) {
        dao.delete(id);
    }

    @Override
    public void update(UsersDto user) {
        dao.update(map.asVo(user));
    }
}
