package com.qaa.model.repository.questions.impl;

import java.util.List;

import com.qaa.api.questions.vo.QuestionsVo;
import com.qaa.api.questions.vo.RoundsVo;
import com.qaa.model.repository.questions.RoundsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class RoundsDaoImpl implements RoundsDao {

  public static final String ID = "ID";

  public static final String NAME = "name";

  @Autowired
  MongoTemplate mt;
  
  @Override
  public void save(RoundsVo quest) {
    mt.save(quest);
  }

  @Override
  public void update(RoundsVo round) {
    final Query query = new Query();
    query.addCriteria(Criteria.where(ID).is(round.getId()));
    final Update newRound = new Update();
    newRound.set(NAME, round.getName());
    mt.updateFirst(query, newRound, QuestionsVo.class);
  }

  @Override
  public List<RoundsVo> findAll() {
   return mt.findAll(RoundsVo.class);
  }

  @Override
  public List<RoundsVo> findBy() {
    return null;
  }

  @Override
  public void delete(String id) {
    final Query query = new Query();
    query.addCriteria(Criteria.where(ID).is(id));
    mt.remove(query, RoundsVo.class);
  }
}