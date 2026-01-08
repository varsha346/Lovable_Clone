package com.lovable.demo.Dto.Member;

import com.lovable.demo.enums.ProjectRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.antlr.v4.runtime.misc.NotNull;

public record InviteMemberRequest(
       @Email @NotBlank String email,
        @NotNull ProjectRole role
) {
}
