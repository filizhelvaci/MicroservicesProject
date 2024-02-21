package com.flz.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//    http://localhost:9092/buyer
@RequiredArgsConstructor
@RestController
@RequestMapping("/buyer")
public class BuyerController {

    //http://localhost:9092/buyer'de bişey olmadğı için bişey olmaz

   // http://localhost:9092/buyer/slm
    @GetMapping("/slm")
    public String slm(){
        return "BuyerService Selam";
    }
}