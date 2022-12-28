package com.qaa.model.service.questions;

import com.qaa.api.questions.dto.QuestionDto;


import java.util.List;


public interface QuestionsService {
    void save(QuestionDto quest);

    void update(QuestionDto quest);

    List<QuestionDto> findAll();

    List<QuestionDto> findBy();

    void delete(Long id);
}

