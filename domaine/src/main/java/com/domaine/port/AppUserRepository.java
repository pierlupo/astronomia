package com.domaine.port;

import com.domaine.model.AppUser;

import java.util.Optional;

public interface AppUserRepository {

    AppUser save(AppUser appUser);

    AppUser findByUsernameAndPassword(String username, String password);

    AppUser findByUsername(String username);

    Optional<AppUser> findByUserName(String username);

    AppUser findById(int id);

    void delete(Optional<AppUser> appUser);
}

