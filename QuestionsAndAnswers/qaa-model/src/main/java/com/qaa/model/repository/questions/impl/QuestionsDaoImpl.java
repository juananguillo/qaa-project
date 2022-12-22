package com.qaa.model.repository.questions.impl;

import com.qaa.api.questions.vo.QuestionsVo;
import com.qaa.model.repository.questions.QuestionsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class QuestionsDaoImpl implements QuestionsDao {

  public static final String ID = "id";
  public static final String QUESTION = "question";
  @Autowired
  private MongoTemplate mt;

  @Override
  public void save(QuestionsVo quest) {
    mt.save(quest);
  }

  @Override
  public void update(QuestionsVo quest) {
    final Query query = new Query();
    query.addCriteria(Criteria.where(ID).is(quest.getId()));
    final Update newQuest = new Update();
    newQuest.set(QUESTION, quest.getQuestion());
    mt.updateFirst(query, newQuest, QuestionsVo.class);
  }

  @Override
  public List<QuestionsVo> findAll() {
    return mt.findAll(QuestionsVo.class);
  }

  @Override
  public List<QuestionsVo> findBy() {
    return null;
  }

  @Override
  public void delete(String id) {
    final Query query = new Query();
    query.addCriteria(Criteria.where(ID).is(id));
    mt.remove(query, QuestionsVo.class);
  }
}
