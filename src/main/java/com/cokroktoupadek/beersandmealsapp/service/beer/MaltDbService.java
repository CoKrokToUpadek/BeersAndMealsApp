package com.cokroktoupadek.beersandmealsapp.service.beer;

import com.cokroktoupadek.beersandmealsapp.domain.entity.beer.MaltEntity;
import com.cokroktoupadek.beersandmealsapp.repository.beer.MaltRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MaltDbService {

    private MaltRepository maltRepository;
    @Autowired
    public MaltDbService(MaltRepository maltRepository) {
        this.maltRepository = maltRepository;
    }

    MaltEntity save(MaltEntity maltEntity){
        return maltRepository.save(maltEntity);
    }

    MaltEntity findById(Long id) throws Exception {
        return maltRepository.findById(id).orElseThrow(Exception::new);
    }

    List<MaltEntity> findById() {
        return maltRepository.findAll();
    }

    void deleteById(Long id){
        maltRepository.deleteById(id);
    }

    void deleteAll(){
        maltRepository.deleteAll();
    }
}