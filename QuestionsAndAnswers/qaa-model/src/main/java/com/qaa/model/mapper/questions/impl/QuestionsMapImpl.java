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

        return Optional.ofNullable(list).orElse(Collections.emptyList()).stream().map(l -> new QuestionsDto(l.getId().toString(), l.getQuestion(), l.getRoundsId().toString())).collect(Collectors.toList());
    }

    @Override
    public QuestionsDto asDTo(QuestionsVo quest) {
        
        return new QuestionsDto(quest.getId().toString(), quest.getQuestion(), quest.getRoundsId().toString());
    }

    @Override
    public QuestionsVo asVo(QuestionsDto quest) {
        QuestionsVo newquest = new QuestionsVo();

        newquest.setQuestion(quest.getQuestion());
        newquest.setRoundsId(new ObjectId(quest.getRoundsId()));

        return newquest;
    }

    @Override
    public List<QuestionsVo> asVos(List<QuestionsDto> list) {
        return Optional.ofNullable(list).orElse(Collections.emptyList()).stream().map(l -> new QuestionsVo(new ObjectId(), l.getQuestion(), new ObjectId(l.getRoundsId()))).collect(Collectors.toList());

    }
}
