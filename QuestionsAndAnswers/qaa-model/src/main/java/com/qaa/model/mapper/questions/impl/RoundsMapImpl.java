package com.qaa.model.mapper.questions.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.qaa.api.questions.dto.QuestionsDto;
import com.qaa.api.questions.dto.RoundsDto;
import com.qaa.api.questions.vo.RoundsVo;
import com.qaa.model.mapper.questions.QuestionsMap;
import com.qaa.model.mapper.questions.RoundsMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("roundsMapper")
public class RoundsMapImpl implements RoundsMap {

  @Autowired
  QuestionsMap questionsMap;
  
  @Override
  public List<RoundsDto> asDTos(List<RoundsVo> list) {
    return Optional.ofNullable(list).orElse(Collections.emptyList()).stream().map(l -> new RoundsDto(l.getId().toString(), l.getName(), questionsMap.asDTos(l.getQuestions()))).collect(
        Collectors.toList());
  }

  @Override
  public RoundsDto asDTo(RoundsVo rounds) {
    return new RoundsDto(rounds.getId().toString(),rounds.getName(), questionsMap.asDTos(rounds.getQuestions()));
  }

  @Override
  public RoundsVo asVo(RoundsDto rounds) {
   RoundsVo newRounds = new RoundsVo();
   
   newRounds.setName(rounds.getName());
   newRounds.setQuestions(questionsMap.asVos(rounds.getQuestions()));
   return newRounds;
  }
}
