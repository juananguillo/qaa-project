package com.qaa.model.mapper.questions.impl;


import com.qaa.api.questions.dto.QuestionsDto;
import com.qaa.api.questions.vo.QuestionsVo;
import com.qaa.model.mapper.questions.QuestionsMap;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component("questionMapper")
public class QuestionsMapImpl implements QuestionsMap {
    @Override
    public List<QuestionsDto> asDTos(List<QuestionsVo> list) {

        return list.stream().map(l -> new QuestionsDto(l.getId().toString(), l.getQuestion(), l.getUserId().toString())).collect(Collectors.toList());
    }

    @Override
    public QuestionsDto asDTo(QuestionsVo quest) {
        QuestionsDto response= new QuestionsDto(quest.getId().toString(), quest.getQuestion(), quest.getUserId().toString());

        return response;
    }

    @Override
    public QuestionsVo asVo(QuestionsDto quest) {
        QuestionsVo response = new QuestionsVo();

        response.setQuestion(quest.getQuestion());
        response.setUserId(new ObjectId());

        return response;
    }
}
