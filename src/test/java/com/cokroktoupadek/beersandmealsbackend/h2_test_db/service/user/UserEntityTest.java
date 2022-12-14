package com.cokroktoupadek.beersandmealsbackend.h2_test_db.service.user;

import com.cokroktoupadek.beersandmealsbackend.domain.entity.user.UserEntity;
import com.cokroktoupadek.beersandmealsbackend.repository.user.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@Transactional
@SpringBootTest
@TestPropertySource("classpath:application-H2TestDb.properties")
class UserEntityTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testCreateUser() {
        //Given
        UserEntity user = new UserEntity("test", "test","test","test@test.cm","test","test","user",LocalDate.now());

        //When
        userRepository.save(user);

        //Then
        Long userId = user.getId();
        Optional<UserEntity> readUser = userRepository.findById(userId);
        if (readUser.isEmpty()){
            Assertions.fail("fetched value is empty");
        }else {
            assertEquals(user.getId(), readUser.get().getId());
        }

        //Cleanup
        userRepository.deleteById(userId);
    }

}