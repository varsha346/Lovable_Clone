package com.lovable.demo.entity;


import com.lovable.demo.enums.ProjectRole;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//used instead of func(this.x = x , this.y = y..)
@Builder
@Table(name = "projects")


@FieldDefaults(level = AccessLevel.PRIVATE)

public class ProjectMember {
ProjectMemberId id;
Project project;
User user;
ProjectRole projectRole;
Instant invitedAt;
Instant acceptedAt;

}
