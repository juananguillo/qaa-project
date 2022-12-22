package com.qaa.api.questions;

import com.qaa.api.questions.dto.QuestionsDto;
import com.qaa.model.service.questions.QuestionsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/questions/")
public class QuestionsController {

    @Autowired
    private QuestionsService service;


    @GetMapping(value = "api/findAll")
    public @ResponseBody List<QuestionsDto> findAll(){
        return service.findAll();
    }

    @PostMapping(value = "api/save")
    public void save(final @Valid @RequestBody QuestionsDto quest){
        System.out.println(1);
        service.save(quest);
    }

    @DeleteMapping(value = "api/delete/{id}")
    public void delete(final @PathVariable(value ="id") String id){
        service.delete(id);
    }
}