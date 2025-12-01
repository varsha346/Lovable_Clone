package com.lovable.demo.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProjectFile {
    long id;
    Project project;
    String path;
    String miniObjectKey;
    Instant createdAt;
    Instant updatedAt;
    User createdBy;
    User UpdatedBy;
}
