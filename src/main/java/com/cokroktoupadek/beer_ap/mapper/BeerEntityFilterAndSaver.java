package com.cokroktoupadek.beer_ap.mapper;

import com.cokroktoupadek.beer_ap.domain.entity.beer.BeerEntity;


import com.cokroktoupadek.beer_ap.service.beer.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class BeerEntityFilterAndSaver {

   @Autowired
   BeerEntityManipulatorDbService beerEntityManipulatorDbService;


   public BeerEntity beerEntityDataOptimize(BeerEntity beerEntity){
            beerEntity.setBoilVolume(beerEntityManipulatorDbService.boilVolumeDuplicateVerifier(beerEntity.getBoilVolume()));
            beerEntity.setVolume(beerEntityManipulatorDbService.volumeDuplicateVerifier(beerEntity.getVolume()));
            beerEntity.getIngredients().getMaltsList().forEach(e->e.setAmount(beerEntityManipulatorDbService.amountDuplicateVerifier(e.getAmount())));
            beerEntity.getIngredients().getHopsList().forEach(e->e.setAmount(beerEntityManipulatorDbService.amountDuplicateVerifier(e.getAmount())));
            beerEntity.getMethod().getFermentation().setTemp(beerEntityManipulatorDbService.tempDuplicateVerifier(beerEntity.getMethod().getFermentation().getTemp()));
            beerEntity.getMethod().getMashTempsList().forEach(e->e.setTemp(beerEntityManipulatorDbService.tempDuplicateVerifier(e.getTemp())));
       return beerEntity;
   }

   public void beerEntitySave(BeerEntity beerEntity){
       if (!beerEntityManipulatorDbService.beerExistenceInDbVerifier(beerEntity)){
           beerEntityManipulatorDbService.beerEntitySaver(beerEntityDataOptimize(beerEntity));

       }
   }

}


