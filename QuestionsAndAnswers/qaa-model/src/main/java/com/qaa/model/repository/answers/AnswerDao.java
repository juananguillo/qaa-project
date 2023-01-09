package com.qaa.model.repository.answers;

import com.qaa.api.answers.vo.AnswerVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerDao extends JpaRepository<AnswerVo, Long> {

}
