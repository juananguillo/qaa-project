package com.qaa.model.repository.questions;

import java.util.List;

import com.qaa.api.questions.vo.RoundsVo;

public interface RoundsDao {
  void save(RoundsVo quest);

  void update(RoundsVo round);

  List<RoundsVo> findAll();

  List<RoundsVo> findBy();

  void delete(String id);
  
  
}
