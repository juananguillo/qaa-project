package com.qaa.model.mapper.questions.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.qaa.api.questions.dto.RoundDto;
import com.qaa.api.questions.vo.RoundVo;
import com.qaa.model.mapper.questions.QuestionsMap;
import com.qaa.model.mapper.questions.RoundsMap;
import com.qaa.model.mapper.users.UsersMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("roundsMapper")
public class RoundsMapImpl implements RoundsMap {

  @Autowired
  UsersMap userMap;
  
  @Override
  public List<RoundDto> asDTos(List<RoundVo> list) {
    return Optional.ofNullable(list).orElse(Collections.emptyList()).stream().map(l -> new RoundDto(l.getId().toString(), l.getName(), userMap.asDTo(l.getUser()))).collect(
        Collectors.toList());
  }

  @Override
  public RoundDto asDTo(RoundVo rounds) {
    return new RoundDto(rounds.getId().toString(),rounds.getName(), userMap.asDTo(rounds.getUser()));
  }

  @Override
  public RoundVo asVo(RoundDto rounds) {
   RoundVo newRounds = new RoundVo();
   
   newRounds.setName(rounds.getName());
   newRounds.setUser(userMap.asVo(rounds.getUser()));
   
   return newRounds;
  }
}
