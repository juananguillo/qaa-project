package com.qaa.api.users;

import com.qaa.api.users.dto.NewUserDto;
import com.qaa.api.users.dto.UserLogDto;
import com.qaa.model.security.JWTUtil;
import com.qaa.model.service.users.UsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/auth/")
public class AuthController {

    @Autowired
    UsersService usersService;
    
    @Autowired
    private JWTUtil jwtUtil;
    
    @PostMapping(value = "api/login")
    public String login(@Valid @RequestBody UserLogDto user){
        System.out.println("login");
        UserLogDto userlog= usersService.verify(user);
        return (userlog!=null)?jwtUtil.create(String.valueOf(userlog.getId()), userlog.getUsername()) :null;
    
    }

    @PostMapping(value = "api/save")
    public void save(@Valid @RequestBody UserLogDto user){
        usersService.save(user);
    }

    @PostMapping(value = "api/check")
    public boolean exist(@Valid @RequestBody NewUserDto user){
        return usersService.exist(user);
    }
    
    @PutMapping(value = "api/update")
    public void update(@Valid @RequestBody UserLogDto user){
        usersService.updateLogin(user);
    }
}
