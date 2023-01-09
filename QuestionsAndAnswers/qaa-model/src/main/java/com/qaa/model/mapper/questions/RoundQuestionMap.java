package com.qaa.model.mapper.questions;

import java.util.List;

import com.qaa.api.questions.dto.RoundQuestionDto;
import com.qaa.api.questions.vo.RoundQuestionVo;

public interface RoundQuestionMap {

  List<RoundQuestionDto> asDTos(List<RoundQuestionVo> list);
  
  RoundQuestionDto asDTo(RoundQuestionVo rounds);
  
  RoundQuestionVo asVo(RoundQuestionDto rounds);
}
