package com.qaa.model.service.questions.impl;

import java.util.List;

import com.qaa.api.questions.dto.RoundQuestionDto;
import com.qaa.model.mapper.questions.RoundQuestionMap;
import com.qaa.model.repository.questions.RoundQuestionDao;
import com.qaa.model.service.questions.RoundQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoundQuestionServiceImpl implements RoundQuestionService {

  @Autowired
  private RoundQuestionDao dao;
  
  @Autowired
  private RoundQuestionMap map;
  
  @Override
  public void save(RoundQuestionDto quest) {
    dao.save(map.asVo(quest));
  }

  @Override
  public void update(RoundQuestionDto quest) {
      dao.save(map.asVo(quest)); 
  }

  @Override
  public List<RoundQuestionDto> findAll() {
    return map.asDTos(dao.findAll());
  }

  @Override
  public List<RoundQuestionDto> findBy() {
    return null;
  }

  @Override
  public void delete(Long id) {
    dao.deleteById(id);
  }

  @Override
  public RoundQuestionDto findRoundById(Long id) {
    return map.asDTo(dao.findRoundById(id));
  }

}
