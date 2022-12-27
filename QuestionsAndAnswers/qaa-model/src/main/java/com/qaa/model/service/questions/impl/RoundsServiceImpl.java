package com.qaa.model.service.questions.impl;

import java.util.List;

import com.qaa.api.questions.dto.RoundsDto;
import com.qaa.api.questions.vo.RoundsVo;
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
  public void save(RoundsDto quest) {
    dao.save(map.asVo(quest));
  }

  @Override
  public void update(RoundsDto quest) {
      dao.save(map.asVo(quest));
  }

  @Override
  public List<RoundsDto> findAll() {
    return map.asDTos((List<RoundsVo>) dao.findAll());
  }

  @Override
  public List<RoundsDto> findBy() {
    return null;
  }

  @Override
  public void delete(Long id) {
    dao.deleteById(id);
  }
}
