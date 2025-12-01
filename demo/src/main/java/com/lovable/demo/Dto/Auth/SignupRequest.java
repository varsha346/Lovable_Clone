package com.lovable.demo.Dto.Auth;

public record SignupRequest(
        String email,
        String name,
        String password
) {
}
