package com.lovable.demo.entity;
import java.time.Instant;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
//need not to define private for each
     long id;
     String email;
     String passwordHash;
     String name;
     String avatarUrl;

    Instant createdAt;
    Instant updatedAt;
    Instant deletedAt;


}
