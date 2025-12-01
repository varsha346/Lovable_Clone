package com.lovable.demo.Dto.Project;

import java.time.Instant;

public record ProjectSummaryResponse(
        long id,
        String name,
        Instant createdAt,
        Instant updatedAt
) {
}
