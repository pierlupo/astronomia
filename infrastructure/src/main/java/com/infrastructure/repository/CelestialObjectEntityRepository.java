package com.infrastructure.repository;

import com.infrastructure.entity.CelestialObjectEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CelestialObjectEntityRepository extends CrudRepository<CelestialObjectEntity, Integer> {
    List<CelestialObjectEntity> findAllByDate(LocalDateTime dateTime);
}
