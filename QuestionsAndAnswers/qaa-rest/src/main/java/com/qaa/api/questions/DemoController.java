package com.qaa.api.questions;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/demo/")
public class DemoController {
    @GetMapping(value = "api/findAll")
    public @ResponseBody String findAll(){
        return "hola";
    }
}
