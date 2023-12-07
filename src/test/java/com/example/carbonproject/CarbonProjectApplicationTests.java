package com.example.carbonproject;

import com.example.carbonproject.config.JwtConfig;
import io.jsonwebtoken.ExpiredJwtException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CarbonProjectApplicationTests {
    @Autowired
    private JwtConfig jwtConfig;

    @Test
    void contextLoads() throws InterruptedException {
        String token = jwtConfig.createToken("test");
        System.out.println(token);
        try {
            System.out.println(jwtConfig.getSubject(token));
        } catch (ExpiredJwtException e) {
            System.out.println("过期");
        }
    }

}
