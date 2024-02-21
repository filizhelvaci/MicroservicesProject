package com.flz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HelloController {

    // http://localhost:9094
    @GetMapping("/")
    public String hello(){
        return "SellerService Hello";
    }

    // http://localhost:9094/info
    @GetMapping("/info")
    public String info(){
        return "INFO: SellerService ";

    }
}
