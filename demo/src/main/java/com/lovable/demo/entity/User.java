package com.lovable.demo.entity;
import java.time.Instant;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "users")
public class User {
//need not to define private for each
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long id;
     String email;
     String passwordHash;
     String name;
     String avatarUrl;

     @CreationTimestamp
    Instant createdAt;
     @UpdateTimestamp
    Instant updatedAt;
    Instant deletedAt;


}
