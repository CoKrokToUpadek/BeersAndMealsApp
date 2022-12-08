package com.cokroktoupadek.beer_ap.h2_test_db.components;

import com.cokroktoupadek.beer_ap.domain.entity.user.UserEntity;
import com.cokroktoupadek.beer_ap.repository.user.UserRepository;
import com.cokroktoupadek.beer_ap.service.user.BeerUserDetailsService;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
@TestPropertySource("classpath:application-H2TestDb.properties")
public class ComponentsTests {

    @Autowired
    BeerUserDetailsService service;

    @Autowired
    UserRepository userRepository;
    @Test
    void assertNullUserTest(){
        //given
        //when
        //then
         assertThrows(UsernameNotFoundException.class, () -> {
             service.loadUserByUsername("sdadsaasdasaas");
         });

    }


    @Test
    void assertFoundEmailTest(){
        //given
       UserEntity userEntity=new UserEntity("firstname","lastname","1","testemail","1","1","1", LocalDate.now());
       userRepository.save(userEntity);
        //when
       Optional<UserEntity> entity= userRepository.findByLogin("1");
        //then
       assertTrue(entity.isPresent());
    }

}
