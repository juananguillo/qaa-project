package com.qaa.model.mapper.questions.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.qaa.api.questions.dto.RoundDto;
import com.qaa.api.questions.vo.RoundVo;
import com.qaa.model.mapper.questions.QuestionsMap;
import com.qaa.model.mapper.questions.RoundsMap;
import com.qaa.model.repository.users.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("roundsMapper")
public class RoundsMapImpl implements RoundsMap {

  
  
  @Autowired
  UsersDao userDao;
  
  @Autowired
  QuestionsMap questionsMap;
  
  @Override
  public List<RoundDto> asDTos(List<RoundVo> list) {
    return Optional.ofNullable(list).orElse(Collections.emptyList()).stream().map(l -> new RoundDto(l.getId(), l.getName(), l.getDescription(), l.getUser().getId(), questionsMap.asDTos(l.getQuestions()))).collect(
        Collectors.toList());
  }

  @Override
  public RoundDto asDTo(RoundVo rounds) {
    return new RoundDto(rounds.getId(),rounds.getName(), rounds.getDescription(), rounds.getUser().getId(), questionsMap.asDTos(rounds.getQuestions()));
  }

  @Override
  public RoundVo asVo(RoundDto rounds) {
   RoundVo newRounds = new RoundVo();
   newRounds.setName(rounds.getName());
   newRounds.setDescription(rounds.getDescription());
   newRounds.setUser(userDao.getReferenceById(rounds.getUserid()));
   newRounds.setQuestions(questionsMap.asVos(rounds.getQuestions()));
   newRounds.setId(rounds.getId());
   return newRounds;
  }
  
}
