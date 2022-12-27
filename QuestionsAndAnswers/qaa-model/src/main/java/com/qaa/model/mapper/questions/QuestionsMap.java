package com.qaa.model.mapper.questions;

import com.qaa.api.questions.dto.QuestionsDto;
import com.qaa.api.questions.vo.QuestionsVo;

import java.util.List;

public interface QuestionsMap {

    List<QuestionsDto> asDTos(List<QuestionsVo> list);

    QuestionsDto asDTo(QuestionsVo quest);

    QuestionsVo asVo(QuestionsDto quest);
    
    List<QuestionsVo> asVos(List<QuestionsDto> list);
}