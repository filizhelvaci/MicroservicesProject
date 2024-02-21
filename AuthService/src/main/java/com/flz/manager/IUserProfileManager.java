package com.flz.manager;

import com.flz.dto.request.UserProfileSaveRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="user-profile-manager",url="http://localhost:9095/user")
public interface IUserProfileManager {
    @PostMapping("/save")
    ResponseEntity<Boolean> save(@RequestBody UserProfileSaveRequestDto dto);


}
