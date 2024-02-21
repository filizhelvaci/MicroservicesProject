package com.flz.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder // bir sınıfın kolayca nesne oluşturmasını sağlar
@Data //set get metotlarını otomatik tanımlar
@NoArgsConstructor
@AllArgsConstructor
public class DoRegisterRequestDto {

    private String username;

    // @Email kısmı burdada yapılabilir.
    private String email;


    // private static final String PASSWORD_PATTERN =
    //        "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
    // constant -> EndPoint'ede koyabiliriz bu kısmı
    //  @NotBlank (message = "Şifre boş geçilemez.")
    //@Pattern(regexp = PASSWORD_PATTERN)
    private String password;
    private String rePassword;
}
