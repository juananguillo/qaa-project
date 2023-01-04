package com.qaa.model.mapper.users;

import java.util.List;

import com.qaa.api.users.dto.UsersDto;
import com.qaa.api.users.vo.UserVo;

public interface UsersMap {

  List<UsersDto> asDTos(List<UserVo> list);

  UsersDto asDTo(UserVo user);

  UserVo asVo(UsersDto user);
}
