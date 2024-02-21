package com.flz.controller;

import com.flz.AuthServiceApp;
import com.flz.constant.EndPoint;
import com.flz.dto.request.DoLoginRequestDto;
import com.flz.dto.request.DoRegisterRequestDto;
import com.flz.dto.response.DoRegisterResponseDto;
import com.flz.model.Auth;
import com.flz.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.flz.constant.EndPoint.AUTH;
import static com.flz.constant.EndPoint.GETALL;

//    http://localhost:9090/auth
@RequiredArgsConstructor
@RestController
@RequestMapping(AUTH)
public class AuthController {

     /*  // eskide kalan enjekte edilme durumu
    @Autowired
    private final AuthService authService;
    */



  /*  // 2. durum tavsiye edilen

    private final AuthService authService;

    public AuthController(AuthService authService) {

        this.authService = authService;
    } */


    // 3. durum lombok ile yapılan - sinifin üstüne ekle bunu @RequiredArgsConstructor
  private final AuthService authService;

    /*
    @PostMapping(EndPoint.REGISTER)
    public ResponseEntity<Auth> doRegister1(@RequestBody DoRegisterRequestDto dto){
        System.out.println("DTO: "+ dto);
        return ResponseEntity.ok(authService.doRegister(dto));
    }
    */

    // http://localhost:9090/auth/register
    @PostMapping(EndPoint.REGISTER)
    public ResponseEntity<DoRegisterResponseDto> doRegister(@RequestBody DoRegisterRequestDto dto){
        System.out.println("DTO: "+ dto);
        return ResponseEntity.ok(authService.doRegister(dto));
    }

    // http://localhost:9090/auth/login
    @PostMapping(EndPoint.LOGIN)
    public ResponseEntity<String> doLogin(@RequestBody DoLoginRequestDto dto){
        System.out.println("DTO: "+ dto);
        return ResponseEntity.ok(authService.doLogin(dto));
    }
/*
    @GetMapping(GETALL)
    public ResponseEntity<  List <Auth>  > findAll()   {

        return ResponseEntity.ok(authService.findAll());
    } */

    //TOKENLA GET
    @GetMapping(GETALL)
    public ResponseEntity<  List <Auth>  > findAll(String token)   {

        return ResponseEntity.ok(authService.findAll(token));
    }



    public ResponseEntity<String> getMessage(){

        return ResponseEntity.ok("AuthServis mesajı");
    }

}
