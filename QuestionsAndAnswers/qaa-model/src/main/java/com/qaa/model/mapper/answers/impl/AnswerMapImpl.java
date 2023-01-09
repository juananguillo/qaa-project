package com.qaa.model.mapper.answers.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.qaa.api.answers.dto.AnswerDto;
import com.qaa.api.answers.vo.AnswerVo;
import com.qaa.api.questions.dto.QuestionDto;
import com.qaa.model.mapper.answers.AnswerMap;
import org.springframework.stereotype.Component;

@Component("answerMapper")
public class AnswerMapImpl implements AnswerMap {

  @Override
  public List<AnswerDto> asDTos(List<AnswerVo> list) {

    return Optional.ofNullable(list).orElse(Collections.emptyList()).stream().map(l -> new AnswerDto(l.getId(), l.getAnswer(), l.getNote())).collect(
        Collectors.toList());

  }

  @Override
  public AnswerDto asDTo(AnswerVo quest) {
    return new AnswerDto(quest.getId(), quest.getAnswer(), quest.getNote());
  }

  @Override
  public AnswerVo asVo(AnswerDto quest) {
    return new AnswerVo(quest.getId(), quest.getAnswer(), quest.getNote());
  }

  @Override
  public List<AnswerVo> asVos(List<AnswerDto> list) {
   return Optional.ofNullable(list).orElse(Collections.emptyList()).stream().map(l -> new AnswerVo(l.getId(), l.getAnswer(), l.getNote())).collect(
        Collectors.toList());
  }
}
