package com.domaine.port;

import com.domaine.model.AppUser;

import java.util.Optional;

public interface AppUserService {

    AppUser createUser(String username, String password);
    AppUser getUserByUserNameAndPassword(String username, String password);
    Optional<AppUser> getUserByUserName(String username);
    Optional<AppUser> getUserById(int id);
    void deleteAppUser(int id);
}
