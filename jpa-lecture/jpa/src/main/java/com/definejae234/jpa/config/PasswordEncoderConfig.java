package com.definejae234.jpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class PasswordEncoderConfig {
    // 복호화 없음 암호화만 가능 (단방향)
    // Spring Controller에 등록됨 => 사용자가 new로 생성하지 않아도 된다. 자동 주입
    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
