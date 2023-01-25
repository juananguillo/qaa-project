package com.qaa.model.security;

import com.qaa.api.users.roles.RoleVo;
import com.qaa.api.users.vo.UserVo;
import com.qaa.model.service.users.UsersService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.management.relation.Role;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {
    
    @Autowired
    private UsersService usersService;
    
    @Autowired
    private JWTUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        // get JWT (token) from http request
        String token = getJWTfromRequest(request);
        // validate token
        try {
            if(StringUtils.hasText(token) && jwtUtil.validateToken(token)){
                // get username from token
             
                // load user associated with token
                UserDetails userDetails = getUserDetails(token);
                System.out.println("userDetails: "+userDetails.getAuthorities().toString());
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities()
                );
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                // set spring security
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        filterChain.doFilter(request, response);
    }

    // Bearer <accessToken>
    public String getJWTfromRequest(HttpServletRequest request){
        String bearerToken = request.getHeader("Authorization");
        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")){
            return bearerToken.substring(7, bearerToken.length());
        }
        return null;
    }

    public UserDetails getUserDetails(String token) {
        UserVo userDetails = new UserVo();
        Claims claims = jwtUtil.parseClaims(token);
        String roles = (String) claims.get("roles");

        roles = roles.replace("[", "").replace("]", "");
        String[] roleNames = roles.split(",");
        
        List<RoleVo> listRoles=new ArrayList<>();
        for (String aRoleName : roleNames) {
            RoleVo rol=new RoleVo();
            rol.setRolName(aRoleName);
           listRoles.add(rol);
        }
        userDetails.setUserRoles(listRoles);
     

        userDetails.setId(Long.parseLong(claims.getId()));
        userDetails.setUsername(claims.getSubject());

        return userDetails;
    }
    
}
