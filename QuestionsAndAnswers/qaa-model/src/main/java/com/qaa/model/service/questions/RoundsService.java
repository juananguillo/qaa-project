package com.qaa.model.service.questions;

import java.util.List;

import com.qaa.api.questions.dto.RoundDto;

public interface RoundsService {
  void save(RoundDto quest);

  void update(RoundDto quest);

  List<RoundDto> findAll();

  List<RoundDto> findBy();

  void delete(Long id);
}
