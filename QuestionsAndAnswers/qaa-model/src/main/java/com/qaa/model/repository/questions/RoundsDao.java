package com.qaa.model.repository.questions;

import java.util.List;

import com.qaa.api.questions.vo.RoundsVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoundsDao extends JpaRepository<RoundsVo, Long> {
  
  
}
