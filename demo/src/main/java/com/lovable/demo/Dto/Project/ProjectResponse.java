package com.lovable.demo.Dto.Project;

import com.lovable.demo.Dto.Auth.UserProfileResponse;

import java.time.Instant;

public record ProjectResponse(
        long id,
        String name,
        Instant createdAt,
        Instant updatedAt,
        UserProfileResponse owner
) {
}
