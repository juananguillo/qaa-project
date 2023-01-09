package com.qaa.model.repository.answers;

import com.qaa.api.answers.vo.RoundAnswerVo;
import com.qaa.api.questions.vo.RoundQuestionVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoundAnswerDao extends JpaRepository<RoundAnswerVo, Long> {

  //@Query("select r from RoundAnswerVo")
  @Query("select r from RoundAnswerVo r join fetch r.user u join fetch r.round join fetch r.answers where r.id=?1")
  RoundAnswerVo findRoundById(Long id);
}
