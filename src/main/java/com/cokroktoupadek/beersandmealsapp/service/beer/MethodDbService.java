package com.cokroktoupadek.beersandmealsapp.service.beer;

import com.cokroktoupadek.beersandmealsapp.domain.entity.beer.MethodEntity;
import com.cokroktoupadek.beersandmealsapp.repository.beer.MethodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MethodDbService {

   private MethodRepository methodRepository;
    @Autowired
    public MethodDbService(MethodRepository methodRepository) {
        this.methodRepository = methodRepository;
    }

    MethodEntity save(MethodEntity methodEntity){
        return methodRepository.save(methodEntity);
    }

    MethodEntity findById(Long id) throws Exception {
        return methodRepository.findById(id).orElseThrow(Exception::new);
    }

    List<MethodEntity> findById() {
        return methodRepository.findAll();
    }


    void deleteById(Long id){
        methodRepository.deleteById(id);
    }

    void deleteAll(){
        methodRepository.deleteAll();
    }
}