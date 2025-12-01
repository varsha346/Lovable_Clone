package com.lovable.demo.entity;

import com.lovable.demo.enums.PreviewStatus;

import java.time.Instant;

public class Preview {
    long id;
    Project project;
    String namespace;
    String podName;
    String previewUrl;
    PreviewStatus status;
    Instant startedAt;
    Instant terminatedAt;
    Instant createdAt;
}
