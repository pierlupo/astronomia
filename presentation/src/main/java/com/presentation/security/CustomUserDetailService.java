package com.presentation.security;



import com.domaine.model.AppUser;
import com.domaine.port.AppUserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CustomUserDetailService implements UserDetailsService {




   private final AppUserService appUserService;

    public CustomUserDetailService(AppUserService appUserService) {
        this.appUserService = appUserService;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser userApp = appUserService.getUserByUserName(username).get();
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("user"));
        return new User(userApp.getUsername(), userApp.getPassword(),authorities);
    }
}
