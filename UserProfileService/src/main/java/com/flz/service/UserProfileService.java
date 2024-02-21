package com.flz.service;

import com.flz.dto.request.UserProfileSaveRequestDto;
import com.flz.mapper.IUserProfileMapper;
import com.flz.model.UserProfile;
import com.flz.repository.IUserProfileRepository;
import com.flz.utils.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService extends ServiceManager<UserProfile,Long> {

     //Enjeksiyon işlemi
     private final IUserProfileRepository repository;

     public UserProfileService(IUserProfileRepository repository) {
         super(repository);
         this.repository = repository;
    }

    public Boolean save(UserProfileSaveRequestDto dto){

         //Eski bir yöntem
        /*
         UserProfile userProfile=new UserProfile();
         userProfile.setId(dto.getAuthId());
         userProfile.setUsername(dto.getUsername());
         userProfile.setEmail(dto.getEmail());
       */

       // Bu da diğer bir yöntem
        /*
        UserProfile userProfile=UserProfile.builder()
                .authId(dto.getAuthId())
                .username(dto.getUsername())
                .email(dto.getEmail())
                .build();
         save(userProfile);
         */

        // Buda bir başka yol
        /*
        save( UserProfile.builder()
                .authId(dto.getAuthId())
                .username(dto.getUsername())
                .email(dto.getEmail())
                .build());
                */

        // Mapperla en modern yol bu
        save(IUserProfileMapper.INSTANCE.toUserProfile(dto));

        return true;

    }
}