package com.lovable.demo.Dto.Auth;

public record LoginRequest(
        String email,
        String password
) {
}
