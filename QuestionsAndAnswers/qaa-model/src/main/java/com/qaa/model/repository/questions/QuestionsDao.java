package com.qaa.model.repository.questions;

import com.qaa.api.questions.vo.QuestionVo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionsDao  extends JpaRepository<QuestionVo, Long> {

  



}
