package com.qaa.model.mapper.users.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.qaa.api.users.dto.UserDto;
import com.qaa.api.users.vo.UserVo;
import com.qaa.model.mapper.questions.RoundQuestionMap;
import com.qaa.model.mapper.users.UserMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("usersmapper")
public class UserMapImpl implements UserMap {

  @Autowired
  RoundQuestionMap roundQuestionMap;
  
  @Override
  public List<UserDto> asDTos(List<UserVo> list) {
   return Optional.ofNullable(list).orElse(Collections.emptyList()).stream()
        .map(lista -> new UserDto(lista.getId(), lista.getUserName(), lista.getName(), lista.getSurname(),
            lista.getDescription(), lista.getAge(), roundQuestionMap.asDTos(lista.getRounds())))
        .collect(Collectors.toList());
  }
  

  @Override
  public UserDto asDTo(UserVo user) {
    return new UserDto(user.getId(), user.getUserName(), user.getName(), user.getSurname(),
        user.getDescription(), user.getAge(), roundQuestionMap.asDTos(user.getRounds()));
  }

  @Override
  public UserVo asVo(UserDto user) {
    UserVo newUser = new UserVo();
    
    newUser.setUserName(user.getUserName());
    newUser.setName(user.getName());
    newUser.setSurname(user.getSurname());
    newUser.setDescription(user.getDescription());
    newUser.setAge(user.getAge());
    return newUser;
  }
}
