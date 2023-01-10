package com.qaa.api.answers;

import com.qaa.api.answers.dto.RoundAnswerDto;
import com.qaa.model.service.answers.RoundAnswerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/roundsanswers/")
public class RoundAnswerController {
    
    @Autowired
    private RoundAnswerService roundAnswerService;


    @PostMapping(value = "api/save")
    public void save(@Valid @RequestBody RoundAnswerDto rounds){
        roundAnswerService.save(rounds);

    }

    @PutMapping(value= "api/update")
    public void update(@Valid @RequestBody RoundAnswerDto rounds){
        roundAnswerService.update(rounds);
    }

    @GetMapping(value = "api/findAll")
    public List<RoundAnswerDto> findAll(){
        return roundAnswerService.findAll();
    }

    @DeleteMapping(value = "api/delete/{id}")
    public void delete (@PathVariable(value= "id") Long id){
        roundAnswerService.delete(id);
    }

    @GetMapping(value = "api/findRound/{id}")
    public RoundAnswerDto findRound(@PathVariable(value = "id") Long id){return roundAnswerService.findRoundById(id);}
}
