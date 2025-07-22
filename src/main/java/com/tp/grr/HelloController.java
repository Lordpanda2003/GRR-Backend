package com.tp.grr;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "👋 Bonjour depuis Spring Boot GRR!";
    }
}
