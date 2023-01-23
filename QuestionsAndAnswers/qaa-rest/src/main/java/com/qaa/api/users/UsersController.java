package com.qaa.api.users;

import java.util.List;

import com.qaa.api.users.dto.UserDto;
import com.qaa.model.service.users.UsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users/")
public class UsersController {

  @Autowired
  UsersService usersService;

  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @GetMapping(value = "/api/findAll")
  public List<UserDto> findAll(){
    return usersService.findAll();
  }
  
  
  @DeleteMapping(value = "api/delete/{id}")
  public void delete(@PathVariable(value = "id") Long id){
    usersService.delete(id);
  }
  
  @PutMapping(value = "api/update")
  public void update(@Valid @RequestBody UserDto user){
     usersService.updateInfo(user);
  }
  
}
