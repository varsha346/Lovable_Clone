package com.lovable.demo.Dto.Auth;

public record UserProfileResponse(
        long id,
        String email,
        String name,
        String avatarUrl

) {
}
