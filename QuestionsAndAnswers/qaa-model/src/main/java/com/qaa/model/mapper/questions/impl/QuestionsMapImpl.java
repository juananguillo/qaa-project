package com.qaa.model.mapper.questions.impl;


import com.qaa.api.questions.dto.QuestionsDto;
import com.qaa.api.questions.vo.QuestionsVo;
import com.qaa.model.mapper.questions.QuestionsMap;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component("questionMapper")
public class QuestionsMapImpl implements QuestionsMap {
    @Override
    public List<QuestionsDto> asDTos(List<QuestionsVo> list) {

        return Optional.ofNullable(list).orElse(Collections.emptyList()).stream().map(l -> new QuestionsDto(l.getId(), l.getQuestion(), l.getRoundId())).collect(Collectors.toList());
    }

    @Override
    public QuestionsDto asDTo(QuestionsVo quest) {
        
        return new QuestionsDto(quest.getId(), quest.getQuestion(), quest.getRoundId());
    }

    @Override
    public QuestionsVo asVo(QuestionsDto quest) {
        QuestionsVo newquest = new QuestionsVo();

        newquest.setQuestion(quest.getQuestion());
        newquest.setRoundId(quest.getRoundId());

        return newquest;
    }

    @Override
    public List<QuestionsVo> asVos(List<QuestionsDto> list) {
        return Optional.ofNullable(list).orElse(Collections.emptyList()).stream().map(l -> new QuestionsVo(l.getId(), l.getQuestion(), l.getRoundId())).collect(Collectors.toList());

    }
}
