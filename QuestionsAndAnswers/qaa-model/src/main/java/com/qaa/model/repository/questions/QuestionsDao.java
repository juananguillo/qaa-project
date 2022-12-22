package com.qaa.model.repository.questions;

import java.util.List;

import com.qaa.api.questions.vo.QuestionsVo;
import org.springframework.stereotype.Repository;


public interface QuestionsDao {

  void save(QuestionsVo quest);

  void update(QuestionsVo quest);

  List<QuestionsVo> findAll();

  List<QuestionsVo> findBy();

  void delete(String id);



}
