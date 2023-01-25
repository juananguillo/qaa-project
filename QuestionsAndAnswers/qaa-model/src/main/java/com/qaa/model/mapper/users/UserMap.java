package com.qaa.model.mapper.users;

import java.util.List;

import com.qaa.api.users.dto.NewUserDto;
import com.qaa.api.users.dto.UserDto;
import com.qaa.api.users.dto.UserLogDto;
import com.qaa.api.users.vo.UserVo;

public interface UserMap {

  List<UserDto> asDTos(List<UserVo> list);

  UserDto asDTo(UserVo user);

  UserVo asVo(UserDto user);

  UserVo asVoEnroll(NewUserDto user);
  
  UserLogDto asDtoEnroll(UserVo user);
}
