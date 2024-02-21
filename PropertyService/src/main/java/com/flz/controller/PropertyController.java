package com.flz.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//    http://localhost:9093/property
@RequiredArgsConstructor
@RestController
@RequestMapping("/property")
public class PropertyController {

    //http://localhost:9093/propertyda bişey olmadğı için bişey olmaz

   // http://localhost:9093/property/slm
    @GetMapping("/slm")
    public String slm(){
        return "PropertyService Selam";
    }
}