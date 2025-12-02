package com.lovable.demo.Dto.Project;

import java.time.Instant;

public record FileNode(
        String path,
        Instant modifiedAt,
        long size,
        String type

) {
}
