package com.qaa.model.repository.questions;

import com.qaa.api.questions.vo.RoundVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoundsDao extends JpaRepository<RoundVo, Long> {
  

}
