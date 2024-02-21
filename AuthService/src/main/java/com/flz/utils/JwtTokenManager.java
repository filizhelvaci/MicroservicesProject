package com.flz.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

@Component
public class JwtTokenManager {
/*
    String secretKey="123";
    String issuer="abc";
    Long exDate=1000L*60*2; //2 dakika
*/
    //"123"
    @Value("${authservice.secret.key}")
    String secretKey;

    //"abc"
    @Value(value = "${authservice.issuer}")
    String issuer;

    //1000L*60*2
    @Value("${authservice.expire.date}")
    Long expireDate; //2 dakika1

    // 1.adım : token üret
    public Optional<String> createToken(Long id){
        String token="";
       try {
           token = JWT.create().withAudience()
                   .withClaim("id", id)
                   .withClaim("serviceName", "Authservice")
                   .withClaim("lastJoin", System.currentTimeMillis())
                   .withIssuer(issuer) //jwt tokeni oluşturan yapi
                   .withIssuedAt(new Date()) // jwt oluşturulma zamanı
                   .withExpiresAt(new Date(System.currentTimeMillis() + expireDate))
                   .sign(Algorithm.HMAC512(secretKey));
           return Optional.of(token);

       }catch (Exception e) {
           return Optional.empty();
       }
    }

    // 2.adım : token doğrula
    public Boolean verifyToken(String token){

        try{
            Algorithm algorithm=Algorithm.HMAC512(secretKey);
            JWTVerifier verifier=JWT.require(algorithm).withIssuer(issuer).build();
            DecodedJWT decodedJWT=verifier.verify(token);

            if(decodedJWT==null) {
               return false;
            }
        }catch(Exception e) {
               return false;
        }
        return true;
    }


    // 3.token içinden bilgiyiçöz ve çıkar
    public Optional<Long> getIdInfoFromToken(String token){
        try{
            Algorithm algorithm=Algorithm.HMAC512(secretKey);
            JWTVerifier verifier=JWT.require(algorithm).withIssuer(issuer).build();
            DecodedJWT decodedJWT=verifier.verify(token);

            if(decodedJWT==null) {
                return Optional.empty();
                }
            Long id=decodedJWT.getClaim("id").asLong();
            System.out.println("Tokendaki id değeri: "+ id);

            String serviceN=decodedJWT.getClaim("serviceName").asString();
            System.out.println("Tokendaki service adı: "+ serviceN );

            return Optional.of(id);

        }catch(Exception e) {
            return Optional.empty();
        }
    }
}
