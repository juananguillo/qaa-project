package com.qaa.model.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {
    
    @Autowired
    private JwtAuthEntryPoint unauthorizeHandler;
    
    @Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
    private JwtAuthFilter jwtAuthFilter;
    
    @Bean
    protected  SecurityFilterChain securityFilterChain(HttpSecurity http, AuthenticationManager authManager) throws Exception {
        http.cors().disable().csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint(unauthorizeHandler)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers(HttpMethod.GET, "/api/v1/**").permitAll()
                                .requestMatchers("/auth/api/login").permitAll()
                                .requestMatchers("/auth/api/save").permitAll()
                                .requestMatchers("/v2/api-docs/**").permitAll()
                                .requestMatchers("/swagger-ui/**").permitAll()
                                .requestMatchers("/swagger-resources/**").permitAll()
                                .requestMatchers("/swagger-ui.html").permitAll()
                                .requestMatchers("/auth/api/check").permitAll()
                                .anyRequest()
                                .authenticated()
                        
                );
    
         http.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
         return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers(new AntPathRequestMatcher("/h2-console/**"));
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
        
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
                
                
    
}
