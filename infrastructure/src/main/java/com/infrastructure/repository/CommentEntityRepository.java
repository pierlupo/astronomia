package com.infrastructure.repository;

import com.infrastructure.entity.CommentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentEntityRepository extends CrudRepository<CommentEntity, Integer> {
    List<CommentEntity> findByCelestialObjectId(int id);
}
