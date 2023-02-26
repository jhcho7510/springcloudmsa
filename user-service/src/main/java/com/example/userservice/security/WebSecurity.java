package com.example.userservice.security;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.RequestMapping;

@Configuration
@EnableWebSecurity
public class WebSecurity {

    private static final String[] WHITE_LIST = {
            "/users/**",
            "/**"
    };

//    @Bean
//    protected SecurityFilterChain config(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//        http.headers().frameOptions().disable();
//        http.authorizeHttpRequests(authorize -> authorize
//                .requestMatchers("/users/**").permitAll()
//                .requestMatchers(PathRequest.toH2Console()).permitAll()
//        );
//        return http.build();
//    }

    @Bean
    protected SecurityFilterChain config(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().frameOptions().disable();
        http.authorizeHttpRequests(authorize -> authorize
                .requestMatchers(WHITE_LIST).permitAll());
        return http.build();
    }

}