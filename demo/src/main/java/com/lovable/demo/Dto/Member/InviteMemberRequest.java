package com.lovable.demo.Dto.Member;

import com.lovable.demo.enums.ProjectRole;

public record InviteMemberRequest(
        String email,
        ProjectRole role
) {
}
