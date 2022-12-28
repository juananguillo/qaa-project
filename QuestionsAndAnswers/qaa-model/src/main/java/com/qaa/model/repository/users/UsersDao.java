package com.qaa.model.repository.users;

import com.qaa.api.users.vo.UsersVo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersDao extends JpaRepository<UsersVo, Long> {
    
  
}
