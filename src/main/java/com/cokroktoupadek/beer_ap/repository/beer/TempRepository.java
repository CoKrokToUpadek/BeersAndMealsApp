package com.cokroktoupadek.beer_ap.repository.beer;

import com.cokroktoupadek.beer_ap.domain.entity.beer.MethodEntity;
import com.cokroktoupadek.beer_ap.domain.entity.beer.TempEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface TempRepository extends CrudRepository<TempEntity, Long> {
    @Override
    List<TempEntity> findAll();

    @Override
    Optional<TempEntity> findById(Long id);

    @Override
    TempEntity save(TempEntity tempEntity);

    @Override
    void deleteById(Long id);

    @Override
    void deleteAll();
}

