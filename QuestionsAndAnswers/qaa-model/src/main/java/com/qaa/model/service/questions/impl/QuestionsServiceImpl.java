package com.qaa.model.service.questions.impl;

import com.qaa.api.questions.dto.QuestionsDto;
import com.qaa.model.mapper.questions.QuestionsMap;
import com.qaa.model.repository.questions.QuestionsDao;
import com.qaa.model.service.questions.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionsServiceImpl implements QuestionsService {

    @Autowired
    private QuestionsDao dao;

    @Autowired
    private QuestionsMap map;

    @Override
    public void save(QuestionsDto quest) {
        dao.save(map.asVo(quest));
    }

    @Override
    public void update(QuestionsDto quest) {
        dao.save(map.asVo(quest));
    }

    @Override
    public List<QuestionsDto> findAll() {
        return map.asDTos(dao.findAll());
    }

    @Override
    public List<QuestionsDto> findBy() {
        return null;
    }

    @Override
    public void delete(Long id) {
        dao.deleteById(id);
    }
}
