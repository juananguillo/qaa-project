package com.qaa.model.repository.questions;

import com.qaa.api.questions.vo.RoundQuestionVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoundQuestionDao extends JpaRepository<RoundQuestionVo, Long> {
  
  @Query("select r from RoundQuestionVo r join fetch r.user u join fetch r.questions where r.id=?1")
  RoundQuestionVo findRoundById(Long id);
  

}
