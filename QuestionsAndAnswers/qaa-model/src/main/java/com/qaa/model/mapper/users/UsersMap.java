package com.qaa.model.mapper.users;

import java.util.List;
import java.util.Optional;

import com.qaa.api.users.dto.UsersDto;
import com.qaa.api.users.vo.UsersVo;

public interface UsersMap {

  List<UsersDto> asDTos(List<UsersVo> list);

  UsersDto asDTo(UsersVo user);

  UsersVo asVo(UsersDto user);
}
