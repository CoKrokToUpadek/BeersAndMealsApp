package com.cokroktoupadek.beersandmealsapp.client.config;

import com.cokroktoupadek.beersandmealsapp.service.user.BeerUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {



    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();// do korekty
    }


    private final BeerUserDetailsService beerUserDetailsService;

    @Autowired
    public SecurityConfig(BeerUserDetailsService beerUserDetailsService) {
        this.beerUserDetailsService = beerUserDetailsService;
    }

    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http
                .csrf().disable()
                .httpBasic()
                .and().anonymous()
                .and().authorizeRequests()
                .mvcMatchers("/**").permitAll()
                .anyRequest().authenticated()
                .and().userDetailsService(beerUserDetailsService)
                .build();
    }

}