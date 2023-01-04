package com.qaa.model.mapper.users.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.qaa.api.users.dto.UsersDto;
import com.qaa.api.users.vo.UserVo;
import com.qaa.model.mapper.questions.RoundsMap;
import com.qaa.model.mapper.users.UsersMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("usersmapper")
public class UsersMapImpl implements UsersMap {

  @Autowired
  RoundsMap roundsMap;
  
  @Override
  public List<UsersDto> asDTos(List<UserVo> list) {
   return Optional.ofNullable(list).orElse(Collections.emptyList()).stream()
        .map(lista -> new UsersDto(lista.getId(), lista.getUserName(), lista.getPwd(), lista.getName(), lista.getSurname(),
            lista.getDescription(), lista.getAge(), roundsMap.asDTos(lista.getRounds())))
        .collect(Collectors.toList());
  }
  

  @Override
  public UsersDto asDTo(UserVo user) {
    return new UsersDto(user.getId(), user.getUserName(), user.getPwd(), user.getName(), user.getSurname(),
        user.getDescription(), user.getAge(), roundsMap.asDTos(user.getRounds()));
  }

  @Override
  public UserVo asVo(UsersDto user) {
    UserVo newUser = new UserVo();
    
    newUser.setUserName(user.getUserName());
    newUser.setName(user.getName());
    newUser.setPwd(user.getPwd());
    newUser.setSurname(user.getSurname());
    newUser.setDescription(user.getDescription());
    newUser.setAge(user.getAge());
    return newUser;
  }
}
