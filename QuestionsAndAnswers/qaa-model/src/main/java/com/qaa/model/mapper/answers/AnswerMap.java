package com.qaa.model.mapper.answers;

import java.util.List;

import com.qaa.api.answers.dto.AnswerDto;
import com.qaa.api.answers.vo.AnswerVo;

public interface AnswerMap {
  List<AnswerDto> asDTos(List<AnswerVo> list);

  AnswerDto asDTo(AnswerVo quest);

  AnswerVo asVo(AnswerDto quest);

  List<AnswerVo> asVos(List<AnswerDto> list);
}
