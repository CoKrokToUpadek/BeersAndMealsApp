package com.cokroktoupadek.beer_ap.service.user;

import com.cokroktoupadek.beer_ap.domain.entity.beer.TempEntity;
import com.cokroktoupadek.beer_ap.domain.entity.user.UserEntity;
import com.cokroktoupadek.beer_ap.errorhandlers.UserNotFoundException;
import com.cokroktoupadek.beer_ap.repository.user.UserRepository;

import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserDbService {
    @Autowired
    private final UserRepository userRepository;


    UserEntity save(UserEntity userEntity){
        return userRepository.save(userEntity);
    }

    UserEntity findById(Long id) throws Exception {
        return userRepository.findById(id).orElseThrow(Exception::new);
    }

    UserEntity findByLogin(String login) throws Exception {
        return userRepository.findByLogin(login).orElseThrow(Exception::new);
    }

    List<UserEntity> findById() {
        return userRepository.findAll();
    }

    void DeleteById(Long id){
        userRepository.deleteById(id);
    }

    void DeleteAll(){
        userRepository.deleteAll();
    }

}