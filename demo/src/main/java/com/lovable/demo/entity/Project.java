package com.lovable.demo.entity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
//used instead of func(this.x = x , this.y = y..)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Project {
    long id;
    String name;
    User user;
    Boolean isPublic = false;
    Instant createdAt;
    Instant updatedAt;
    Instant deletedAt;



}
