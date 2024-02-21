package com.flz.controller;

import com.flz.dto.request.UserProfileSaveRequestDto;
import com.flz.model.UserProfile;
import com.flz.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.flz.constant.EndPoint.GETALL;
import static com.flz.constant.EndPoint.SAVE;

//    http://localhost:9095/user
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserProfileController {

    //http://localhost:9095/userda bişey olmadğı için bişey olmaz

   private final UserProfileService userProfileService;


    // http://localhost:9095/user/slm
    @GetMapping("/slm")
    public String slm(){
        return "UserProfileService Selam";
    }

    // http://localhost:9095/user/save
    @PostMapping(SAVE)
    public ResponseEntity<Boolean> save(@RequestBody UserProfileSaveRequestDto dto){
        return ResponseEntity.ok(userProfileService.save(dto));
    }

    @GetMapping(GETALL)
    public ResponseEntity<List<UserProfile>> findAll()   {

        return ResponseEntity.ok(userProfileService.findAll());
    }

}