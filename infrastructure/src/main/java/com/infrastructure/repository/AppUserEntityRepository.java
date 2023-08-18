package com.infrastructure.repository;

import com.infrastructure.entity.AppUserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserEntityRepository extends CrudRepository <AppUserEntity, Integer>{
    Optional<AppUserEntity> findByUsername(String username);
    AppUserEntity findByUsernameAndPassword(String username, String password);

//    AppUserEntity findByUserName(String username);
}
