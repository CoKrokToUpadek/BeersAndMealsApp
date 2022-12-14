package com.cokroktoupadek.beersandmealsbackend.repository.beer;

import com.cokroktoupadek.beersandmealsbackend.domain.entity.beer.HopsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface HopsRepository extends CrudRepository <HopsEntity, Long>{
    @Override
    List<HopsEntity> findAll();

    @Override
    Optional<HopsEntity> findById(Long id);

    @Override
    HopsEntity save(HopsEntity hopsEntity);

    @Override
    void deleteById(Long id);

    @Override
    void deleteAll();
}


