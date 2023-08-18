package com.domaine.service;

import com.domaine.model.AppUser;
import com.domaine.port.AppUserRepository;
import com.domaine.port.AppUserService;

import java.util.Optional;

public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository appUserRepository;

    public AppUserServiceImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public AppUser createUser(String username, String password) {
        AppUser appUser = new AppUser(username, password);
        return appUserRepository.save(appUser);
    }

    @Override
    public AppUser getUserByUserNameAndPassword(String username, String password) {
        return appUserRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public Optional<AppUser> getUserByUserName(String username) {
        return appUserRepository.findByUsername(username);
    }

    @Override
    public Optional<AppUser> getUserById(int id) {
        return Optional.ofNullable(appUserRepository.findById(id));
    }

    @Override
    public void deleteAppUser(int id) {
        try {
            Optional<AppUser> appUser = getUserById(id);
            appUserRepository.delete(appUser);
        }catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}
