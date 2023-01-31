package com.cokroktoupadek.beersandmealsbackend.client.config;

import com.cokroktoupadek.beersandmealsbackend.service.user.BeersAndMealsUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
//public class SecurityConfig {
//
//    private final BeersAndMealsUserDetailsService beerUserDetailsService;
//
//    @Autowired
//    public SecurityConfig(BeersAndMealsUserDetailsService beerUserDetailsService) {
//        this.beerUserDetailsService = beerUserDetailsService;
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//
//    @Bean
//    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
//        return http
//                .csrf().disable()
//                .httpBasic()
//                .and().anonymous()
//                .and().authorizeRequests()
//                .mvcMatchers("/**").permitAll()
//                .anyRequest().authenticated()
//                .and().userDetailsService(beerUserDetailsService)
//                .build();
//    }
//
//
//}
