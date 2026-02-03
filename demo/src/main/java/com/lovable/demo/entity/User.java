package com.lovable.demo.entity;
import java.time.Instant;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.lovable.demo.enums.ProjectRole;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

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

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<ProjectRole> roles;

    @Column(unique = true)
    String RazorCustomerId;
     @CreationTimestamp
    Instant createdAt;
     @UpdateTimestamp
    Instant updatedAt;
    Instant deletedAt;

}
