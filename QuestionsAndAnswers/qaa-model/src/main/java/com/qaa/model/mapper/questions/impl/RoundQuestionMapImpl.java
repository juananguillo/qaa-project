package com.qaa.model.mapper.questions.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.qaa.api.questions.dto.RoundQuestionDto;
import com.qaa.api.questions.vo.RoundQuestionVo;
import com.qaa.model.mapper.questions.QuestionMap;
import com.qaa.model.mapper.questions.RoundQuestionMap;
import com.qaa.model.repository.users.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("roundsQuestionMapper")
public class RoundQuestionMapImpl implements RoundQuestionMap {

  
  
  @Autowired
  UserDao userDao;
  
  @Autowired
  QuestionMap questionMap;
  
  @Override
  public List<RoundQuestionDto> asDTos(List<RoundQuestionVo> list) {
    System.out.println(list);
    return Optional.ofNullable(list).orElse(Collections.emptyList()).stream().map(l -> new RoundQuestionDto(l.getId(), l.getName(), l.getDescription(), l.getUser().getId(), questionMap.asDTos(l.getQuestions()))).collect(
        Collectors.toList());
  }

  @Override
  public RoundQuestionDto asDTo(RoundQuestionVo rounds) {
    return new RoundQuestionDto(rounds.getId(),rounds.getName(), rounds.getDescription(), rounds.getUser().getId(), questionMap.asDTos(rounds.getQuestions()));
  }

  @Override
  public RoundQuestionVo asVo(RoundQuestionDto rounds) {
   RoundQuestionVo newRounds = new RoundQuestionVo();
   newRounds.setName(rounds.getName());
   newRounds.setDescription(rounds.getDescription());
   newRounds.setUser(userDao.getReferenceById(rounds.getUserid()));
   newRounds.setQuestions(questionMap.asVos(rounds.getQuestions()));
   newRounds.setId(rounds.getId());
   return newRounds;
  }
  
}
