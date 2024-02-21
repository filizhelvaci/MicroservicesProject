package com.flz.service;

import com.flz.dto.request.DoLoginRequestDto;
import com.flz.dto.request.DoRegisterRequestDto;
import com.flz.dto.response.DoRegisterResponseDto;
import com.flz.exception.AuthServiceException;
import com.flz.exception.ErrType;
// import com.flz.manager.IUserProfileManager;
import com.flz.mapper.IAuthMapper;
import com.flz.model.Auth;
import com.flz.repository.IAuthRepository;
import com.flz.utils.JwtTokenManager;
import com.flz.utils.ServiceManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthService extends ServiceManager<Auth,Long> {

     //Enjeksiyon işlemi
      private final IAuthRepository repository;

      private final JwtTokenManager jwtTokenManager;
     //private final IUserProfileManager userProfileManager;

    public AuthService(IAuthRepository repository, JwtTokenManager jwtTokenManager) {
        super(repository);
        this.repository = repository;
        this.jwtTokenManager = jwtTokenManager;

    }

    public Auth doRegister1(DoRegisterRequestDto dto) {

        System.out.println("DoRegisterRequestDto: "+dto);

        //if (repository.existsByUsername(dto.getUsername()))
         //   throw new Exception();

        Auth auth=new Auth();
        auth.setUsername(dto.getUsername());

        // TODO password rePassword
        auth.setPassword(dto.getPassword());
        auth.setEmail(dto.getEmail());
        auth.setCreateAt(System.currentTimeMillis());
        auth.setState(true);
        save(auth);
        System.out.println("auth : "+auth);

        return auth;
    }

    public DoRegisterResponseDto doRegister(DoRegisterRequestDto dto) {

        System.out.println("DoRegisterRequestDto: "+dto);

        if (!dto.getPassword().equals(dto.getRePassword()))
        {
            throw new AuthServiceException(ErrType.REGISTER_PASSWORD_MISMATCH);
        }

       /* Auth auth=new Auth();
        auth.setUsername(dto.getUsername());

        auth.setPassword(dto.getPassword());
        auth.setEmail(dto.getEmail());
        auth.setCreateAt(System.currentTimeMillis());
        auth.setState(true);
        save(auth);
*/

        //Lombok ile Farklı bir yollada nesne oluşturabiliriz
     /*   Auth auth=save(Auth.builder()
                .username(dto.getUsername())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .createAt(System.currentTimeMillis())
                .state(true)
                .build());

     */

        // MAPPERLA DTO KARŞILAMA
        Auth auth= IAuthMapper.INSTANCE.toAuth(dto);
        //auth.setCreateAt(System.currentTimeMillis()); tarih için @createdDate anotation kullandık baseEntity
        //auth.setState(true);
        save(auth);


/*        // Baska bir servisi cagiriyoruz
        userProfileManager.save(UserProfileSaveRequestDto.builder()
                .authId(auth.getId())
                .username(auth.getUsername())
                .email(auth.getEmail())
                .build());

        // Baska bir servisi mapper ile cagiriyoruz.
        userProfileManager.save(IAuthMapper.INSTANCE.fromAuth(auth));

*/
        System.out.println("auth: " +  auth);

        DoRegisterResponseDto responseDto = new DoRegisterResponseDto();
        responseDto.setUsername(dto.getUsername());
        responseDto.setEmail(dto.getEmail());
        return responseDto;

    }

 // Jwt siz sıradan bir login

    public String doLoginOld(DoLoginRequestDto dto) {

       Optional<Auth> auth= repository.findOptionalByUsernameAndPassword(dto.getUsername(), dto.getPassword());
       if(auth.isEmpty()) {
           throw new AuthServiceException(ErrType.DOLOGIN_USERNAMEORPASSWORD_NOTEXISTS);
       }

        return auth.get().getId().toString();
    }

    public String doLogin(DoLoginRequestDto dto) {

        Optional<Auth> auth= repository.findOptionalByUsernameAndPassword(dto.getUsername(), dto.getPassword());
        if(auth.isEmpty()) {
            throw new AuthServiceException(ErrType.DOLOGIN_USERNAMEORPASSWORD_NOTEXISTS);
        }

        return jwtTokenManager.createToken(auth.get().getId()).get();
    }

    public List<Auth> findAll(String token) {

        Optional<Long> id=null;
        try{
            id=jwtTokenManager.getIdInfoFromToken(token);
        }catch (Exception e){
            throw new AuthServiceException(ErrType.INVALID_TOKEN);
        }
        if(findById(id.get()).isEmpty())
            throw new AuthServiceException(ErrType.INVALID_TOKEN);

        return repository.findAll();
    }
}
