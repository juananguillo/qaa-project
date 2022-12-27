package com.qaa.model.mapper.questions;

import java.util.List;

import com.qaa.api.questions.dto.RoundsDto;
import com.qaa.api.questions.vo.RoundsVo;

public interface RoundsMap {

  List<RoundsDto> asDTos(List<RoundsVo> list);
  
  RoundsDto asDTo(RoundsVo rounds);
  
  RoundsVo asVo(RoundsDto rounds);
}
