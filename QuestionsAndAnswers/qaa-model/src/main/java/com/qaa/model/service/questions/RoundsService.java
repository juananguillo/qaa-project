package com.qaa.model.service.questions;

import java.util.List;

import com.qaa.api.questions.dto.RoundsDto;

public interface RoundsService {
  void save(RoundsDto quest);

  void update(RoundsDto quest);

  List<RoundsDto> findAll();

  List<RoundsDto> findBy();

  void delete(String id);
}
