package com.lautharo.restjpa.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HellowController {

    @GetMapping("/hellow")

    public String hellow(){
        return "Hellow ";
    }

}
