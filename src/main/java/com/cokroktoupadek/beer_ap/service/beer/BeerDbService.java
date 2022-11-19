package com.cokroktoupadek.beer_ap.service.beer;

import com.cokroktoupadek.beer_ap.domain.entity.beer.AmountEntity;
import com.cokroktoupadek.beer_ap.domain.entity.beer.BeerEntity;
import com.cokroktoupadek.beer_ap.repository.beer.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BeerDbService {
    @Autowired
    BeerRepository beerRepository;

    BeerEntity save(BeerEntity beerEntity){
        return beerRepository.save(beerEntity);
    }

    BeerEntity findById(Long id) throws Exception {
        return beerRepository.findById(id).orElseThrow(Exception::new);
    }

    List<BeerEntity> findById() {
        return beerRepository.findAll();
    }
    void DeleteById(Long id){
        beerRepository.deleteById(id);
    }

    void DeleteAll(){
        beerRepository.deleteAll();
    }

}