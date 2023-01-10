package com.qaa.model.mapper.answers.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.qaa.api.answers.dto.RoundAnswerDto;
import com.qaa.api.answers.vo.RoundAnswerVo;
import com.qaa.model.mapper.answers.AnswerMap;
import com.qaa.model.mapper.answers.RoundAnswerMap;
import com.qaa.model.repository.questions.RoundQuestionDao;
import com.qaa.model.repository.users.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("roundsAnswerMapper")
public class RoundAnswerMapImpl implements RoundAnswerMap {
  
  @Autowired
  AnswerMap answerMap;
  
  @Autowired
  UserDao userDao;

  @Autowired
  RoundQuestionDao roundQuestionDao;
  
  
  
  @Override
  public List<RoundAnswerDto> asDTos(List<RoundAnswerVo> list) {
    return Optional.ofNullable(list).orElse(Collections.emptyList()).stream().map(l -> new RoundAnswerDto(l.getId(), l.getMatch(), l.getUser().getId(), l.getRound().getId(), answerMap.asDTos(l.getAnswers()))).collect(
        Collectors.toList());
  }

  
  @Override
  public RoundAnswerDto asDTo(RoundAnswerVo rounds) {
    return new RoundAnswerDto(rounds.getId(), rounds.getMatch(), rounds.getUser().getId(), rounds.getRound().getId(), answerMap.asDTos(rounds.getAnswers()));
  }

  @Override
  public RoundAnswerVo asVo(RoundAnswerDto rounds) {
    RoundAnswerVo newRounds = new RoundAnswerVo();
    newRounds.setId(rounds.getId());
    newRounds.setUser(userDao.getReferenceById(rounds.getUserId()));
    newRounds.setRound(roundQuestionDao.getReferenceById(rounds.getRoundId()));
    newRounds.setAnswers(answerMap.asVos(rounds.getAnswers()));
    System.out.println(newRounds);
    return newRounds;
  }
}
