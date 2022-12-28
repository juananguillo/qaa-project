package com.qaa.model.mapper.questions;

import java.util.List;

import com.qaa.api.questions.dto.RoundDto;
import com.qaa.api.questions.vo.RoundVo;

public interface RoundsMap {

  List<RoundDto> asDTos(List<RoundVo> list);
  
  RoundDto asDTo(RoundVo rounds);
  
  RoundVo asVo(RoundDto rounds);
}
