package com.mustoutdoor.testserverapi.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Component
@RestController
@RequestMapping("/")
public class HelloController {

    @GetMapping("hello")
    public String HealthCheck() {
        return "I'm ok, Good ! ! !";
    }

}
