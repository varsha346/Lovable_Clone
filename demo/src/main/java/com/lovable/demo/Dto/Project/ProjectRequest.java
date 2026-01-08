package com.lovable.demo.Dto.Project;

import jakarta.validation.constraints.NotBlank;

public record ProjectRequest(
      @NotBlank String name
) {
}
