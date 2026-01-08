package com.lovable.demo.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class ProjectMemberId {
    long projectId;
    long userId;

    public ProjectMemberId(Long projectId, Long id) {
    }
}
