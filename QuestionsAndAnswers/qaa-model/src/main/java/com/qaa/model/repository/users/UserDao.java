package com.qaa.model.repository.users;

import com.qaa.api.questions.vo.RoundQuestionVo;
import com.qaa.api.users.vo.UserVo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface UserDao extends JpaRepository<UserVo, Long> {
  
  @Modifying
  @Query("update UserVo u set u.name=:name, u.surname=:surname, u.description=:description, u.age=:age where u.id=:id")
  void update(@Param("id") Long id, @Param("name") String name, @Param("surname") String surname, @Param("description") String description,@Param("age") int age);

  
  @Modifying
  @Query("update UserVo u set u.username=:username, u.mail=:email where u.id=:id")
  void updateLogin(@Param("id") Long id, @Param("username") String username,@Param("email") String email);

  @Modifying
  @Query("update UserVo u set u.pwd=:pwd where u.id=:id")
  void updatePwd(@Param("id") Long id, @Param("pwd") String pwd);
  
  @Query("select u from UserVo u where u.username=:username or u.mail=:email")
  UserVo verify(@Param("username") String username, @Param("email") String email);

  @Query("select case when count(u)>0 then true else false end from UserVo u where u.username=:username or u.mail=:email")
  boolean exists(@Param("username") String username, @Param("email") String email);


  public UserVo findByUsername(String username);

}
