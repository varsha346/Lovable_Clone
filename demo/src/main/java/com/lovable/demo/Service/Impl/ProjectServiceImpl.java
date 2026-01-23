package com.lovable.demo.Service.Impl;

import com.lovable.demo.Dto.Project.ProjectRequest;
import com.lovable.demo.Dto.Project.ProjectResponse;
import com.lovable.demo.Dto.Project.ProjectSummaryResponse;
import com.lovable.demo.Security.AuthUtil;
import com.lovable.demo.Service.ProjectService;
import com.lovable.demo.entity.Project;
import com.lovable.demo.entity.ProjectMember;
import com.lovable.demo.entity.ProjectMemberId;
import com.lovable.demo.entity.User;
import com.lovable.demo.enums.ProjectRole;
import com.lovable.demo.mapper.ProjectMapper;
import com.lovable.demo.repository.ProjectMemberRepository;
import com.lovable.demo.repository.ProjectRepository;
import com.lovable.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Transactional
public class ProjectServiceImpl implements ProjectService {


    ProjectRepository projectRepository;
    UserRepository userRepository;
    ProjectMapper projectMapper;
    ProjectMemberRepository projectMemberRepository;
   AuthUtil authUtil;

    @Override
    public ProjectResponse createProject(ProjectRequest request) {
        Long userId = authUtil.getCurrentUserId();
//     User owner = userRepository.findById(userId).orElseThrow();
        //ProjectMember projectMember = ProjectMemberRepository.
     Project project = Project.builder()
             .name(request.name())
             .isPublic(false)
                      .build();
;
     project = projectRepository.save(project);
        ProjectMemberId projectMemberId = new ProjectMemberId(project.getId(),userId);
        ProjectMember projectMember = ProjectMember.builder()
                .id(projectMemberId)
                .projectRole(ProjectRole.OWNER)

                .acceptedAt(Instant.now())
                .invitedAt(Instant.now())
                .project(project)
                .build();

        projectMemberRepository.save(projectMember);


    //  long userId = authUtil.getCurrentUserId();
        return projectMapper.toProjectResponse(project);
    }
    @Override
    public List<ProjectSummaryResponse> getUserProjects() {
        Long userId = authUtil.getCurrentUserId();
        var projects = projectRepository.findAllAccessibleByUser(userId);
        return projectMapper.toListOfProjectSummaryResponse(projects);
    }

    @Override
    public ProjectResponse getUserProjectById(long id) {
        Long userId = authUtil.getCurrentUserId();
        Project project = getAccessibleProjectById(id, userId);
        return projectMapper.toProjectResponse(project);
       
    }


    @Override
    public ProjectResponse updateProject(long id, ProjectRequest request) {
        Long userId = authUtil.getCurrentUserId();
        Project project = projectRepository.findAccessibleProjectById(id,userId).orElseThrow();
        project.setName(request.name());
        project = projectRepository.save(project);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public void softDelete(long id) {
        Long userId = authUtil.getCurrentUserId();
      Project project = getAccessibleProjectById(id,userId);
//      if(!project.getUser().getId().equals(userId)){
//         throw new RuntimeException("You are not allowed to delete");
//      }
      project.setDeletedAt(Instant.now());
      projectRepository.save(project);
    }
    public Project getAccessibleProjectById(Long projectId,Long userId){
        return projectRepository.findAccessibleProjectById(projectId,userId).orElseThrow();

    }
}

