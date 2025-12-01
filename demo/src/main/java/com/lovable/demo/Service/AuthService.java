package com.lovable.demo.Service;

import com.lovable.demo.Dto.Auth.AuthResponse;
import com.lovable.demo.Dto.Auth.LoginRequest;
import com.lovable.demo.Dto.Auth.SignupRequest;
import org.jspecify.annotations.Nullable;

public interface AuthService {
      AuthResponse signup(SignupRequest request);
      AuthResponse login(LoginRequest request);
}
