package com.cokroktoupadek.beer_ap.entity.beer;

import com.cokroktoupadek.beer_ap.domain.entity.beer.VolumeEntity;
import com.cokroktoupadek.beer_ap.repository.beer.VolumeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class VolumeEntityTest {
    @Autowired
    VolumeRepository volumeRepository;

    @Test
    void addVolumeTest(){
        //given
        VolumeEntity volumeEntity=new VolumeEntity(1,"testVolume");
        //when
        volumeRepository.save(volumeEntity);
        //then
        Long id=volumeEntity.getId();
        Optional<VolumeEntity> fetchedVolumeEntity=volumeRepository.findById(id);
        if (fetchedVolumeEntity.isEmpty()){
            Assertions.fail("fetched value is empty");
        }else {
            Assertions.assertEquals(fetchedVolumeEntity.get().getId(), volumeEntity.getId());
        }
        //cleanup
        volumeRepository.deleteAll();
    }

}