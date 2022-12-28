package com.qaa.model.repository.questions;

import com.qaa.api.questions.vo.RoundVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoundsDao extends JpaRepository<RoundVo, Long> {
  
  
}
