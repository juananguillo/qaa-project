package com.qaa.model.mapper.answers;

import java.util.List;

import com.qaa.api.answers.dto.RoundAnswerDto;
import com.qaa.api.answers.vo.RoundAnswerVo;

public interface RoundAnswerMap {

  List<RoundAnswerDto> asDTos(List<RoundAnswerVo> list);

  RoundAnswerDto asDTo(RoundAnswerVo rounds);

  RoundAnswerVo asVo(RoundAnswerDto rounds);
}
