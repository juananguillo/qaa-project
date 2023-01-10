package com.qaa.api.questions;

import java.util.List;

import com.qaa.api.questions.dto.RoundQuestionDto;
import com.qaa.model.service.questions.RoundQuestionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/rounds/")
public class RoundQuestionController {

  @Autowired
  private RoundQuestionService roundQuestionService;
  
  @PostMapping(value = "api/save")
  public void save(@Valid @RequestBody RoundQuestionDto rounds){
    roundQuestionService.save(rounds);
    
  }
  
  @PutMapping(value= "api/update")
  public void update(@Valid @RequestBody RoundQuestionDto rounds){
    roundQuestionService.update(rounds);
  }
  
  @GetMapping(value = "api/findAll")
  public List<RoundQuestionDto> findAll(){
    return roundQuestionService.findAll();
  }
  
  @DeleteMapping(value = "api/delete/{id}")
  public void delete (@PathVariable(value= "id") Long id){
    roundQuestionService.delete(id);
  }
  
  @GetMapping(value = "api/findRound/{id}")
  public RoundQuestionDto findRound(@PathVariable(value = "id") Long id){return roundQuestionService.findRoundById(id);}
}
