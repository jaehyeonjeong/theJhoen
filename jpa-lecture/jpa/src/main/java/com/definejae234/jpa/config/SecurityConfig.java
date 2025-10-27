package com.definejae234.jpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth ->
                        auth
                                .requestMatchers(
                                        "/",
                                        "/main",
                                        "/index",
                                        "/member/signup",
                                        "/member/login",
                                        "/css/**", "/js/**").permitAll()    // 허용하는 경로
                                .anyRequest().authenticated()
                )
                .csrf(AbstractHttpConfigurer::disable)      // 나의 도메인 내에서만 접속을 허가(disable = 차단)
                .formLogin(form ->
                        form.loginPage("/member/login")     // get으로 사용 (action 값이랑 일치해야함)
                                .loginProcessingUrl("/member/login")        // post
                                .defaultSuccessUrl("/", true)
                                .usernameParameter("userID")  //username
                                .passwordParameter("userPW")  //password
                                .failureUrl("/member/login?error=true")
                                .permitAll()
                )
                .logout(logout ->
                        logout.logoutUrl("/logout")
                                .logoutSuccessUrl("/"));
        return http.build();
    }

    ;
}
