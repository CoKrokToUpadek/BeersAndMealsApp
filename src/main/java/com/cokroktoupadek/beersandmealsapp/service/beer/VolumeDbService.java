package com.cokroktoupadek.beersandmealsapp.service.beer;

import com.cokroktoupadek.beersandmealsapp.domain.entity.beer.VolumeEntity;
import com.cokroktoupadek.beersandmealsapp.repository.beer.VolumeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class VolumeDbService {

    private VolumeRepository volumeRepository;
    @Autowired
    public VolumeDbService(VolumeRepository volumeRepository) {
        this.volumeRepository = volumeRepository;
    }

    VolumeEntity save(VolumeEntity volumeEntity){
        return volumeRepository.save(volumeEntity);
    }

    VolumeEntity findById(Long id) throws Exception {
        return volumeRepository.findById(id).orElseThrow(Exception::new);

    }

    Optional<VolumeEntity> findByUnitAndValue(String unit, Integer value){
        return volumeRepository.findByUnitAndValue(unit,value);
    }



    List<VolumeEntity> findById() {
        return volumeRepository.findAll();
    }

    void deleteById(Long id){
        volumeRepository.deleteById(id);
    }

    void deleteAll(){
        volumeRepository.deleteAll();
    }

    public List<VolumeEntity> findAll() {
        return  volumeRepository.findAll();
    }
}