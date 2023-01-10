package com.qaa.model.service.answers;

import java.util.List;

import com.qaa.api.answers.dto.RoundAnswerDto;

public interface RoundAnswerService {
  void save(RoundAnswerDto quest);

  void update(RoundAnswerDto quest);

  List<RoundAnswerDto> findAll();
  

  void delete(Long id);

  RoundAnswerDto findRoundById(Long id);
}
