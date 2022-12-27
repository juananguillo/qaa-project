package com.qaa.api.questions;

import java.util.List;

import com.qaa.api.questions.dto.RoundsDto;
import com.qaa.model.service.questions.RoundsService;
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
@RequestMapping(path = "/rounds/")
public class RoundsController {

  @Autowired
  private RoundsService roundsService;
  
  @PostMapping(value = "api/save")
  public void save(@Valid @RequestBody RoundsDto rounds){
    roundsService.save(rounds);
    
  }
  
  @PostMapping(value= "api/update")
  public void update(@Valid @RequestBody RoundsDto rounds){
    roundsService.update(rounds);
  }
  
  @GetMapping(value = "api/findAll")
  public List<RoundsDto> findAll(){
    return roundsService.findAll();
  }
  
  @DeleteMapping(value = "api/delete/{id}")
  public void delete (@PathVariable(value= "id") Long id){
    roundsService.delete(id);
  }
}
