package com.qaa.model.service.questions;

import com.qaa.api.questions.dto.QuestionsDto;


import java.util.List;


public interface QuestionsService {
    void save(QuestionsDto quest);

    void update(QuestionsDto quest);

    List<QuestionsDto> findAll();

    List<QuestionsDto> findBy();

    void delete(Long id);
}

