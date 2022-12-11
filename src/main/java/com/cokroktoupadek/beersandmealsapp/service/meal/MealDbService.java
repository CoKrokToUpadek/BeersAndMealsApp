package com.cokroktoupadek.beersandmealsapp.service.meal;


import com.cokroktoupadek.beersandmealsapp.domain.entity.meal.MealEntity;
import com.cokroktoupadek.beersandmealsapp.domain.entity.user.UserEntity;
import com.cokroktoupadek.beersandmealsapp.repository.meal.MealRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.After;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MealDbService {

    MealRepository mealRepository;
    @Autowired
    public MealDbService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    private MealEntity save(MealEntity mealEntity){
        return mealRepository.save(mealEntity);
    }

    public MealEntity findById(Long id)  {
        return mealRepository.findById(id).orElse(null);
    }

    public MealEntity findByName(String name){
        return mealRepository.findByName(name).orElse(null);
    }

    List<MealEntity> findAll() {
        return mealRepository.findAll();
    }

    void DeleteById(Long id) {
        mealRepository.deleteById(id);
    }

    void DeleteAll() {
        mealRepository.deleteAll();
    }


}