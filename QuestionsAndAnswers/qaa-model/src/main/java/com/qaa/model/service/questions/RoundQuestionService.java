package com.qaa.model.service.questions;

import java.util.List;

import com.qaa.api.questions.dto.RoundQuestionDto;

public interface RoundQuestionService {
  void save(RoundQuestionDto quest);

  void update(RoundQuestionDto quest);

  List<RoundQuestionDto> findAll();

  List<RoundQuestionDto> findBy();

  void delete(Long id);
  
  RoundQuestionDto findRoundById(Long id);
}
