package com.qaa.model.service.questions.impl;

import com.qaa.api.questions.dto.QuestionDto;
import com.qaa.model.mapper.questions.QuestionMap;
import com.qaa.model.repository.questions.QuestionDao;
import com.qaa.model.service.questions.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionDao dao;

    @Autowired
    private QuestionMap map;

    @Override
    public void save(QuestionDto quest) {
        dao.save(map.asVo(quest));
    }

    @Override
    public void update(QuestionDto quest) {
        dao.save(map.asVo(quest));
    }

    @Override
    public List<QuestionDto> findAll() {
        return map.asDTos(dao.findAll());
    }

    @Override
    public List<QuestionDto> findBy() {
        return null;
    }

    @Override
    public void delete(Long id) {
        dao.deleteById(id);
    }
}
