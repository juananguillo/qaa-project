package com.qaa.api.users;

import java.util.List;

import com.qaa.api.users.dto.UsersDto;
import com.qaa.model.service.users.UsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/users/")
public class UsersController {

  @Autowired
  UsersService usersService;
  
  @GetMapping(value = "/api/findAll")
  public List<UsersDto> findAll(){
    return usersService.findAll();
  }
  
  
  @PostMapping(value = "api/save")
  public void save(@Valid @RequestBody UsersDto user){
    usersService.save(user);
  }
  
  @DeleteMapping(value = "api/delete/{id}")
  public void delete(@PathVariable(value = "id") Long id){
    usersService.delete(id);
  }
  
  @PostMapping(value = "api/update")
  public void update(@Valid @RequestBody UsersDto user){
    usersService.update(user);
  }
  
}
