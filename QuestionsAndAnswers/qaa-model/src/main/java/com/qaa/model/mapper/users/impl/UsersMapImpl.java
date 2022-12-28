package com.qaa.model.mapper.users.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.qaa.api.users.dto.UsersDto;
import com.qaa.api.users.vo.UsersVo;
import com.qaa.model.mapper.users.UsersMap;
import org.springframework.stereotype.Component;

@Component("usersmapper")
public class UsersMapImpl implements UsersMap {


  
  @Override
  public List<UsersDto> asDTos(List<UsersVo> list) {
   return Optional.ofNullable(list).orElse(Collections.emptyList()).stream()
        .map(lista -> new UsersDto(lista.getId(), lista.getUserName(), lista.getPwd(), lista.getName(), lista.getSurname(),
            lista.getDescription()))
        .collect(Collectors.toList());
  }
  

  @Override
  public UsersDto asDTo(UsersVo user) {
    return new UsersDto(user.getId(), user.getUserName(), user.getPwd(), user.getName(), user.getSurname(),
        user.getDescription());
  }

  @Override
  public UsersVo asVo(UsersDto user) {
    UsersVo newUser = new UsersVo();
    
    newUser.setUserName(user.getUserName());
    newUser.setName(user.getName());
    newUser.setSurname(user.getSurname());
    newUser.setDescription(user.getDescription());

    return newUser;
  }
}
