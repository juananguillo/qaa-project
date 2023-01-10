package com.qaa.model.service.answers.impl;

import java.util.List;

import com.qaa.api.answers.dto.AnswerDto;
import com.qaa.model.mapper.answers.AnswerMap;
import com.qaa.model.repository.answers.AnswerDao;
import com.qaa.model.service.answers.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements AnswerService {

  @Autowired
  AnswerDao dao;
  
  @Autowired
  AnswerMap map;
  
  @Override
  public void save(AnswerDto quest) {
    dao.save(map.asVo(quest));
  }

  @Override
  public void update(AnswerDto quest) {
    dao.save(map.asVo(quest));
  }

  @Override
  public List<AnswerDto> findAll() {
    return map.asDTos(dao.findAll());
  }

  @Override
  public List<AnswerDto> findBy() {
    return null;
  }

  @Override
  public void delete(Long id) {
    dao.deleteById(id);
  }
}
