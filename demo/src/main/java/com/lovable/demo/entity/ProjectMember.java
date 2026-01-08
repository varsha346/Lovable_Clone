package com.lovable.demo.entity;


import com.lovable.demo.enums.ProjectRole;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//used instead of func(this.x = x , this.y = y..)
@Builder
@Table(name = "project_members")

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)

public class ProjectMember {
@EmbeddedId
ProjectMemberId id;

@ManyToOne
@MapsId("projectId")
Project project;

@ManyToOne
@MapsId("userId")
User user;

ProjectRole projectRole;
Instant invitedAt;
Instant acceptedAt;

}
