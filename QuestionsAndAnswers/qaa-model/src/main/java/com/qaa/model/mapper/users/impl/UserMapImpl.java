package com.qaa.model.mapper.users.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.qaa.api.users.dto.UserDto;
import com.qaa.api.users.dto.UserLogDto;
import com.qaa.api.users.roles.RoleVo;
import com.qaa.api.users.vo.UserVo;
import com.qaa.model.mapper.questions.RoundQuestionMap;
import com.qaa.model.mapper.users.UserMap;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("usersmapper")
public class UserMapImpl implements UserMap {

  @Autowired
  RoundQuestionMap roundQuestionMap;
  
  @Override
  public List<UserDto> asDTos(List<UserVo> list) {
   return Optional.ofNullable(list).orElse(Collections.emptyList()).stream()
        .map(lista -> new UserDto(lista.getId(), lista.getUsername(), lista.getName(), lista.getSurname(),
            lista.getDescription(), lista.getAge(), roundQuestionMap.asDTos(lista.getRounds())))
        .collect(Collectors.toList());
  }
  

  @Override
  public UserDto asDTo(UserVo user) {
    return new UserDto(user.getId(), user.getUsername(), user.getName(), user.getSurname(),
        user.getDescription(), user.getAge(), roundQuestionMap.asDTos(user.getRounds()));
  }

  @Override
  public UserVo asVo(UserDto user) {
    UserVo newUser = new UserVo();
    
    newUser.setUsername(user.getUsername());
    newUser.setName(user.getName());
    newUser.setSurname(user.getSurname());
    newUser.setDescription(user.getDescription());
    newUser.setAge(user.getAge());
    return newUser;
  }

  @Override
  public UserVo asVoEnroll(UserLogDto user) {
    UserVo newUser = new UserVo();
    Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
    
    newUser.setId(user.getId());
    newUser.setUsername(user.getUsername());
    newUser.setPwd(argon2.hash(1, 1024, 1, user.getPwd()));
    newUser.setMail(user.getEmail());
    RoleVo role= new RoleVo(1, "USER");
    /*
    INSERT INTO ROLES(ID, ROL_NAME)
    VALUES(1, 'USER')*/
    List roles= new ArrayList<>();
    roles.add(role);
    newUser.setUserRoles(roles);
    
    return newUser;
  }

  @Override
  public UserLogDto asDtoEnroll(UserVo user) {
    return new UserLogDto(user.getId(), user.getUsername(), user.getPwd(), user.getMail());
  }
}
