package com.lovable.demo.repository;

import com.lovable.demo.entity.ProjectMember;
import com.lovable.demo.entity.ProjectMemberId;
import com.lovable.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectMemberRepository extends JpaRepository<ProjectMember, ProjectMemberId> {
    List<ProjectMember> findByProjectId(long projectId);
}
