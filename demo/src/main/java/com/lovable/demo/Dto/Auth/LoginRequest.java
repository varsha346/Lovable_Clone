package com.lovable.demo.Dto.Auth;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginRequest(
       @NotBlank String username,
      @Size(min = 4,max = 50)  String password
) {
}
