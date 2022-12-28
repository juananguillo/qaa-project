package com.qaa.model.service.questions.impl;

import java.util.List;

import com.qaa.api.questions.dto.RoundDto;
import com.qaa.api.questions.vo.RoundVo;
import com.qaa.model.mapper.questions.RoundsMap;
import com.qaa.model.repository.questions.RoundsDao;
import com.qaa.model.service.questions.RoundsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoundsServiceImpl implements RoundsService {

  @Autowired
  private RoundsDao dao;
  
  @Autowired
  private RoundsMap map;
  
  @Override
  public void save(RoundDto quest) {
    dao.save(map.asVo(quest));
  }

  @Override
  public void update(RoundDto quest) {
      dao.save(map.asVo(quest));
  }

  @Override
  public List<RoundDto> findAll() {
    return map.asDTos((List<RoundVo>) dao.findAll());
  }

  @Override
  public List<RoundDto> findBy() {
    return null;
  }

  @Override
  public void delete(Long id) {
    dao.deleteById(id);
  }
}
