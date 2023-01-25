package com.qaa.api.users;

import com.qaa.api.users.dto.NewUserDto;
import com.qaa.api.users.dto.PwdDto;
import com.qaa.api.users.dto.UserLogDto;
import com.qaa.api.users.vo.UserVo;
import com.qaa.model.security.JWTUtil;
import com.qaa.model.service.users.UsersService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
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
        UserVo userlog= usersService.verify(user);
        return (userlog!=null)?jwtUtil.create(userlog) :null;
    
    }

    @PostMapping(value = "api/create")
    public void create(@Valid @RequestBody NewUserDto user) throws Exception {
        usersService.save(user);
    }

    @PostMapping(value = "api/activate")
    public void activate(@Valid @RequestBody NewUserDto user) throws Exception {
        usersService.save(user);
    }

    @GetMapping(value = "api/checkUser/{username}")
    public boolean existUsername(@PathVariable(value = "username") String username){
        return usersService.existUsername(username);
    }

    @GetMapping(value = "api/checkMail/{mail}")
    public boolean existMail(@PathVariable(value = "mail") String mail){
        return usersService.existMail(mail);
    }
    
    @PutMapping(value = "api/changePwd")
    @PreAuthorize("@OwnerValidator.checkUser(#user.getId(),#request)")
    public void update(@Valid @RequestBody PwdDto user, HttpServletRequest request) throws Exception {
        usersService.updatePwd(user);
    }
}
