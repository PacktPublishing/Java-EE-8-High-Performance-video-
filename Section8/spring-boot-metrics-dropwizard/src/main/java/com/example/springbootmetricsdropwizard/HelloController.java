package com.example.springbootmetricsdropwizard;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @Timed
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index() {
        return "Greetings from Spring Boot!";
    }
}