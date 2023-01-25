package com.qaa.model.service.users.impl;

import com.qaa.api.users.dto.NewUserDto;
import com.qaa.api.users.dto.PwdDto;
import com.qaa.api.users.dto.UserDto;
import com.qaa.api.users.dto.UserLogDto;
import com.qaa.api.users.vo.UserVo;
import com.qaa.model.mapper.users.UserMap;
import com.qaa.model.repository.users.UserDao;
import com.qaa.model.service.users.UsersService;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl  implements UsersService {
    
    @Autowired
    UserDao dao;
    
    @Autowired
    UserMap map;
    
    @Override
    public List<UserDto> findAll() {
        return map.asDTos(dao.findAll());
    }

   

    @Override
    public void save(NewUserDto user) {
        if(user.getPwd()!=user.getRepeatedpwd()){
           
        }
        else {
            Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
            user.setPwd(argon2.hash(1, 1024, 1, user.getPwd()));
            dao.save(map.asVoEnroll(user));
        }
    }

    @Override
    public void delete(Long id) {
        dao.deleteById(id);
    }

    @Override
    public void updateInfo(UserDto user) {
      dao.update(user.getId(), user.getName(), user.getSurname(), user.getDescription(), user.getAge());
    }
    

    @Override
    public UserVo verify(UserLogDto user) {
        UserVo userSaved = dao.verify(user.getUsername(), user.getEmail());
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if(userSaved==null) return null;
        return argon2.verify(userSaved.getPwd(), user.getPwd())?userSaved:null;
    }

    @Override
    public boolean existMail(String mail) {
        return dao.existMail(mail);
    }

    @Override
    public boolean existUsername(String username) {
        return dao.existUsername(username);
    }

    @Override
    public void updatePwd(PwdDto user) throws Exception {
        
        if(user.getNewpwd()!=user.getNewpdagain()){
            throw new Exception("Las pwd no coinciden");
        }
        Optional<UserVo> userSaved = dao.findById(user.getId());
        if(userSaved==null) throw new UsernameNotFoundException("No existe el usuario");
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        user.setNewpwd(argon2.hash(1, 1024, 1, user.getNewpwd()));
        
        if(argon2.verify(userSaved.get().getPwd(), user.getNewpwd())){
            dao.updatePwd(userSaved.get().getId(), user.getNewpwd());
        }
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserVo usuario = this.dao.findByUsername(username);
        if(usuario == null){
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        return usuario;
    }
    
}
