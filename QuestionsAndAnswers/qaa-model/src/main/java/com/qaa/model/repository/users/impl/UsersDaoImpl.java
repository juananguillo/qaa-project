package com.qaa.model.repository.users.impl;


import com.qaa.api.users.vo.UsersVo;
import com.qaa.model.repository.users.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsersDaoImpl implements UsersDao {

    public static final String ID = "id";
    public static final String USERNAME = "username";
    public static final String NAME = "name";
    public static final String SURNAME = "surname";
    @Autowired
    MongoTemplate mt;

    @Override
    public List<UsersVo> findAll() {
        return mt.findAll(UsersVo.class);
    }

    @Override
    public UsersVo findById(String id) {
        final Query query = new Query();
        query.addCriteria(Criteria.where(ID).is(id));
        return mt.findById(query, UsersVo.class);
    }

    @Override
    public void save(UsersVo user) {
         mt.save(user);
    }

    @Override
    public void delete(String id) {
        final Query query = new Query();
        query.addCriteria(Criteria.where(ID).is(id));
        mt.remove(query, UsersVo.class);
    }

    @Override
    public void update(UsersVo user) {
        final Query query = new Query();
        query.addCriteria(Criteria.where(ID).is(user.getId()));
        final Update newUser = new Update();
        newUser.set(USERNAME, user.getUserName());
        newUser.set(NAME, user.getName());
        newUser.set(SURNAME, user.getSurname());
        mt.updateFirst(query, newUser, UsersVo.class);
    }
}
