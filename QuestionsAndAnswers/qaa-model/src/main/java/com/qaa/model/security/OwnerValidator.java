package com.qaa.model.security;

import com.qaa.api.users.dto.UserLogDto;
import com.qaa.api.users.vo.UserVo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component("OwnerValidator")
public class OwnerValidator {

    @Autowired
    private JwtAuthFilter jwtUtil;
    
    public boolean checkUser(Long id, HttpServletRequest request){
        UserVo userDetails = (UserVo) jwtUtil.getUserDetails(jwtUtil.getJWTfromRequest(request));
        if(userDetails.getId()!=id){
            return false;
        }
        return true;
      
    }
    
    
}
