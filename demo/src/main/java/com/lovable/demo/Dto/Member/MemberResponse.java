package com.lovable.demo.Dto.Member;

import com.lovable.demo.enums.ProjectRole;

import java.time.Instant;

public record MemberResponse(
        Long userId,
        String username,
        String name,
        String avatarUrl,
        ProjectRole role,
        Instant invitedAt
) {
}
