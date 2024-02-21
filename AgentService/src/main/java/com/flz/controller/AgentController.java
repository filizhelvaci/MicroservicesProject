package com.flz.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

//    http://localhost:9091/agent

@RestController
@RequestMapping("/agent")
public class AgentController {

   // http://localhost:9091/agent/slm
    @GetMapping("/slm")
    public String slm(){
        return "AgentService Selam";
    }
}