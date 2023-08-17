package com.presentation.controller;


import com.domaine.model.AppUser;
import com.domaine.port.AppUserService;
import com.presentation.dto.LoginRequestDTO;
import com.presentation.dto.LoginResponseDTO;
import com.presentation.dto.RegisterRequestDTO;

import com.presentation.dto.RegisterResponseDTO;
import com.presentation.security.JWTGenerator;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/auth")
@RestController
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final AppUserService appUserService;
    private final PasswordEncoder passwordEncoder;
    private final JWTGenerator generator;

    public AuthController(AuthenticationManager authenticationManager, AppUserService appUserService, PasswordEncoder passwordEncoder, JWTGenerator generator) {
        this.authenticationManager = authenticationManager;
        this.appUserService = appUserService;
        this.passwordEncoder = passwordEncoder;
        this.generator = generator;
    }

    @PostMapping("login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDTO.getUsername(), loginRequestDTO.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return ResponseEntity.ok(LoginResponseDTO.builder().token(generator.generateToken(authentication)).build());
        }catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @PostMapping("register")
    public ResponseEntity<RegisterResponseDTO> register(@RequestBody RegisterRequestDTO registerRequestDTO) {
        try {
            AppUser appUser = appUserService.createUser(registerRequestDTO.getUsername(), passwordEncoder.encode(registerRequestDTO.getPassword()));
            return ResponseEntity.ok(RegisterResponseDTO.builder().id(appUser.getId()).message("User created").build());
        }catch (Exception ex) {
            throw new RuntimeException();
        }
    }
}
