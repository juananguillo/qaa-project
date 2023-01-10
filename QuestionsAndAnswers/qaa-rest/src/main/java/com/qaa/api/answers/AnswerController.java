package com.qaa.api.answers;


import com.qaa.api.answers.dto.AnswerDto;
import com.qaa.model.service.answers.AnswerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/answers/")
public class AnswerController {
    
    @Autowired
    private AnswerService service;


    @GetMapping(value = "api/findAll")
    public @ResponseBody List<AnswerDto> findAll(){
        return service.findAll();
        
    }

    @PostMapping(value = "api/save")
    public void save(final @Valid @RequestBody AnswerDto quest){
        service.save(quest);
    }

    @DeleteMapping(value = "api/delete/{id}")
    public void delete(final @PathVariable(value ="id") Long id){
        service.delete(id);
    }

    @PutMapping(value = "api/update")
    public void update(@Valid @RequestBody AnswerDto quest){
        service.update(quest);
    }
}
