package com.qaa.model.mapper.questions.impl;


import com.qaa.api.questions.dto.QuestionDto;
import com.qaa.api.questions.vo.QuestionVo;
import com.qaa.model.mapper.questions.QuestionsMap;
import com.qaa.model.mapper.questions.RoundsMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component("questionMapper")
public class QuestionsMapImpl implements QuestionsMap {
    
    @Autowired
    RoundsMap roundsMap;
    
    @Override
    public List<QuestionDto> asDTos(List<QuestionVo> list) {

        return Optional.ofNullable(list).orElse(Collections.emptyList()).stream().map(l -> new QuestionDto(l.getId(), l.getQuestion(), l.getMin(), roundsMap.asDTo(l.getRound()))).collect(Collectors.toList());
    }

    @Override
    public QuestionDto asDTo(QuestionVo quest) {
        
        return new QuestionDto(quest.getId(), quest.getQuestion(), quest.getMin(), roundsMap.asDTo(quest.getRound()));
    }

    @Override
    public QuestionVo asVo(QuestionDto quest) {
        QuestionVo newquest = new QuestionVo();

        newquest.setQuestion(quest.getQuestion());
        newquest.setRound(roundsMap.asVo(quest.getRound()));
        newquest.setMin(quest.getMin());
        return newquest;
    }

    @Override
    public List<QuestionVo> asVos(List<QuestionDto> list) {
        return Optional.ofNullable(list).orElse(Collections.emptyList()).stream().map(l -> new QuestionVo(l.getId(), l.getQuestion(),l.getMin(), roundsMap.asVo(l.getRound()))).collect(Collectors.toList());

    }
}
