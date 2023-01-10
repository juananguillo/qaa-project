package com.qaa.model.service.answers.impl;

import java.util.List;

import com.qaa.api.answers.dto.RoundAnswerDto;
import com.qaa.model.mapper.answers.RoundAnswerMap;
import com.qaa.model.repository.answers.RoundAnswerDao;
import com.qaa.model.service.answers.RoundAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoundAnswerServiceImpl implements RoundAnswerService {

  @Autowired
  RoundAnswerDao dao;
  
  @Autowired
  RoundAnswerMap map;
  
  @Override
  public void save(RoundAnswerDto quest) {
    dao.save(map.asVo(quest));
  }

  @Override
  public void update(RoundAnswerDto quest) {
    dao.save(map.asVo(quest));
  }

  @Override
  public List<RoundAnswerDto> findAll() {
     return map.asDTos(dao.findAll());
  }

  @Override
  public void delete(Long id) {
    dao.deleteById(id);
  }

  @Override
  public RoundAnswerDto findRoundById(Long id) {
    return map.asDTo(dao.findRoundById(id));
  }
}
