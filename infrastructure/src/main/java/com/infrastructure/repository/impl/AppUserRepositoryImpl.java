package com.infrastructure.repository.impl;

import com.domaine.model.AppUser;
import com.domaine.port.AppUserRepository;
import com.infrastructure.entity.AppUserEntity;
import com.infrastructure.repository.AppUserEntityRepository;
import org.modelmapper.ModelMapper;

import java.util.Optional;

public class AppUserRepositoryImpl implements AppUserRepository {

    private final ModelMapper modelMapper;
    private final AppUserEntityRepository appUserEntityRepository;

    public AppUserRepositoryImpl(ModelMapper modelMapper, AppUserEntityRepository appUserEntityRepository) {
        this.modelMapper = modelMapper;
        this.appUserEntityRepository = appUserEntityRepository;
    }

    @Override
    public AppUser save(AppUser userApp) {
        return modelMapper.map(
                appUserEntityRepository.save(
                        modelMapper.map(userApp, AppUserEntity.class)
                ),AppUser.class
        );
    }

    @Override
    public AppUser findByUsernameAndPassword(String username, String password) {
        return modelMapper.map(
                appUserEntityRepository.findByUsernameAndPassword(username, password), AppUser.class
        );
    }

    @Override
    public AppUser findByUsername(String username) {
        return modelMapper.map(
                appUserEntityRepository.findByUsername(username), AppUser.class
        );
    }

    @Override
    public Optional<AppUser> findByUserName(String username) {
        return Optional.ofNullable(modelMapper.map(
                appUserEntityRepository.findByUserName(username), AppUser.class
        ));
    }

    @Override
    public AppUser findById(int id) {
        return modelMapper.map(
                appUserEntityRepository.findById(id), AppUser.class
        );
    }

    @Override
    public void delete(Optional<AppUser> appUser) {

    }
}
