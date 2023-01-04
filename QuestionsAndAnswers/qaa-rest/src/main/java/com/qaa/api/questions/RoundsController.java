package com.qaa.api.questions;

import java.util.List;

import com.qaa.api.questions.dto.RoundDto;
import com.qaa.model.service.questions.RoundsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/rounds/")
public class RoundsController {

  @Autowired
  private RoundsService roundsService;
  
  @PostMapping(value = "api/save")
  public void save(@Valid @RequestBody RoundDto rounds){
    roundsService.save(rounds);
    
  }
  
  @PutMapping(value= "api/update")
  public void update(@Valid @RequestBody RoundDto rounds){
    roundsService.update(rounds);
  }
  
  @GetMapping(value = "api/findAll")
  public List<RoundDto> findAll(){
    return roundsService.findAll();
  }
  
  @DeleteMapping(value = "api/delete/{id}")
  public void delete (@PathVariable(value= "id") Long id){
    roundsService.delete(id);
  }
}
