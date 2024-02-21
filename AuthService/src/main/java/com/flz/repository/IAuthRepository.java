package com.flz.repository;

import com.flz.model.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAuthRepository extends JpaRepository<Auth,Long> {

    Boolean existsByUsername(String username);

    Optional <Auth> findOptionalByUsernameAndPassword (String username,String password);

    // Optional <Auth> findByAddressEmptyAndEmail(String address, String email);

}