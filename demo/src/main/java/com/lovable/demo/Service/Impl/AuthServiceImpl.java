package com.lovable.demo.Service.Impl;

import com.lovable.demo.Dto.Auth.AuthResponse;
import com.lovable.demo.Dto.Auth.LoginRequest;
import com.lovable.demo.Dto.Auth.SignupRequest;
import com.lovable.demo.Service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public AuthResponse signup(SignupRequest request) {
        return null;
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        return null;
    }
}
