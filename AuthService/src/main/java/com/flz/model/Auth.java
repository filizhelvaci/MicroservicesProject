package com.flz.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder // bir sınıftan nesne türetmek için
@Data//set get metotlarını otomatik tanımlar
@NoArgsConstructor
@AllArgsConstructor
@ToString


@Entity
@Table(name="auth")
public class Auth extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    //@Column(unique = true)
    //@Email
    private String email;

    private String password;

    //private String address;

}
