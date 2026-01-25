package com.lovable.demo.entity;
import java.time.Instant;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "users")
public class User  {
//need not to define private for each
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long id;
     String username;
     String password;
     String name;
     String avatarUrl;


    @Column(unique = true)
    String RazorCustomerId;
     @CreationTimestamp
    Instant createdAt;
     @UpdateTimestamp
    Instant updatedAt;
    Instant deletedAt;

}
