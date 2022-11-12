package com.cokroktoupadek.beer_ap.entity.beer;

import com.cokroktoupadek.beer_ap.domain.entity.beer.MashTempEntity;
import com.cokroktoupadek.beer_ap.domain.entity.beer.TempEntity;
import com.cokroktoupadek.beer_ap.repository.beer.MashTempRepository;
import com.cokroktoupadek.beer_ap.repository.beer.TempRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class MashTempEntityTest {
    @Autowired
    MashTempRepository mashTempRepository;



    @Test
    void addMashTempTest(){
        //given
        TempEntity tempEntity=new TempEntity(1,"testTemp");
        MashTempEntity mashTempEntity =new MashTempEntity(tempEntity,1);
        //when
        mashTempRepository.save(mashTempEntity);
        //then
        Long id= mashTempEntity.getId();
        Optional<MashTempEntity> fetchedMashTempEntity = mashTempRepository.findById(id);
        if (fetchedMashTempEntity.isEmpty()){
            Assertions.fail("fetched value is empty");
        }else {
            Assertions.assertEquals(fetchedMashTempEntity.get().getId(), mashTempEntity.getId());
        }
        //cleanup
        mashTempRepository.deleteAll();

    }
}