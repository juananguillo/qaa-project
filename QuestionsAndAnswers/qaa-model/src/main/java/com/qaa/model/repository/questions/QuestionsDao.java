package com.qaa.model.repository.questions;

import java.util.List;

import com.qaa.api.questions.vo.QuestionsVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface QuestionsDao  extends JpaRepository<QuestionsVo, Long> {

  



}
