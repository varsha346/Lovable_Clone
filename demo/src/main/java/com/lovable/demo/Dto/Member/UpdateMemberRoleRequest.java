package com.lovable.demo.Dto.Member;

import com.lovable.demo.enums.ProjectRole;
import jakarta.validation.constraints.NotNull;

public record UpdateMemberRoleRequest(
      @NotNull ProjectRole role
) {
}
