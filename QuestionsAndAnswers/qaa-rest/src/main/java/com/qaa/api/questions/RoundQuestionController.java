package com.qaa.api.questions;

import java.util.List;

import com.qaa.api.questions.dto.RoundQuestionDto;
import com.qaa.model.service.questions.RoundQuestionService;
import com.qaa.model.security.JWTUtil;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/rounds/")
public class RoundQuestionController {

  @Autowired
  private RoundQuestionService roundQuestionService;
  
  @Autowired
  private JWTUtil jwtUtil;
  
  @PostMapping(value = "api/save")
  public void save(@Valid @RequestBody RoundQuestionDto rounds){
    roundQuestionService.save(rounds);
    
  }
  
  @PutMapping(value= "api/update")
  public void update(@Valid @RequestBody RoundQuestionDto rounds){
    roundQuestionService.update(rounds);
  }

  @RolesAllowed("USER")
  @GetMapping(value = "api/findAll")
  public List<RoundQuestionDto> findAll(@RequestHeader(value = "Authorization") String token){
    return jwtUtil.getKey(token)!=null? roundQuestionService.findAll():null;
  }
  
  @DeleteMapping(value = "api/delete/{id}")
  public void delete (@PathVariable(value= "id") Long id){
    roundQuestionService.delete(id);
  }
  
  @GetMapping(value = "api/findRound/{id}")
  public RoundQuestionDto findRound(@PathVariable(value = "id") Long id){return roundQuestionService.findRoundById(id);}
}
