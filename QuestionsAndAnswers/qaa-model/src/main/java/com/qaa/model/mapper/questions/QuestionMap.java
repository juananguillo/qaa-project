package com.qaa.model.mapper.questions;

import com.qaa.api.questions.dto.QuestionDto;
import com.qaa.api.questions.vo.QuestionVo;

import java.util.List;

public interface QuestionMap {

    List<QuestionDto> asDTos(List<QuestionVo> list);

    QuestionDto asDTo(QuestionVo quest);

    QuestionVo asVo(QuestionDto quest);
    
    List<QuestionVo> asVos(List<QuestionDto> list);
}