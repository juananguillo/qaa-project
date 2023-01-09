package com.qaa.model.service.answers;

import java.util.List;

import com.qaa.api.answers.dto.AnswerDto;

public interface AnswerService {
  void save(AnswerDto quest);

  void update(AnswerDto quest);

  List<AnswerDto> findAll();

  List<AnswerDto> findBy();

  void delete(Long id);
}
