package com.flz.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//    http://localhost:9094/seller
@RequiredArgsConstructor
@RestController
@RequestMapping("/seller")
public class SellerController {

    //http://localhost:9094/seller da bişey olmadğı için bişey olmaz

   // http://localhost:9094/seller/slm
    @GetMapping("/slm")
    public String slm(){
        return "SellerService Selam";
    }
}