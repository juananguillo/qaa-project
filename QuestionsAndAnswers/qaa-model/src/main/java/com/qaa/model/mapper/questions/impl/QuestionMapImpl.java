package com.qaa.model.mapper.questions.impl;


import com.qaa.api.questions.dto.QuestionDto;
import com.qaa.api.questions.vo.QuestionVo;
import com.qaa.model.mapper.questions.QuestionMap;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component("questionMapper")
public class QuestionMapImpl implements QuestionMap {

    
    @Override
    public List<QuestionDto> asDTos(List<QuestionVo> list) {

        return Optional.ofNullable(list).orElse(Collections.emptyList()).stream().map(l -> new QuestionDto(l.getId(), l.getQuestion(), l.getSize(), l.getClue(), l.isOptional())).collect(Collectors.toList());
    }

    @Override
    public QuestionDto asDTo(QuestionVo quest) {
        
        return new QuestionDto(quest.getId(), quest.getQuestion(), quest.getSize(), quest.getClue(), quest.isOptional());
    }

    @Override
    public QuestionVo asVo(QuestionDto quest) {
        QuestionVo newquest = new QuestionVo();

        newquest.setQuestion(quest.getQuestion());
        newquest.setSize(quest.getSize());
        newquest.setId(quest.getId());
        return newquest;
    }

    @Override
    public List<QuestionVo> asVos(List<QuestionDto> list) {
        return Optional.ofNullable(list).orElse(Collections.emptyList()).stream().map(l -> new QuestionVo(l.getId(), l.getQuestion(),l.getSize(), l.getClue(), l.isOptional())).collect(Collectors.toList());

    }
}
