package com.lovable.demo.Service.Impl;

import com.lovable.demo.Dto.Project.ProjectRequest;
import com.lovable.demo.Dto.Project.ProjectResponse;
import com.lovable.demo.Dto.Project.ProjectSummaryResponse;
import com.lovable.demo.Service.ProjectService;
import com.lovable.demo.entity.Project;
import com.lovable.demo.entity.User;
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
//    AuthUtil authUtil;

    @Override
    public ProjectResponse createProject(ProjectRequest request, long userId) {
     User owner = userRepository.findById(userId).orElseThrow();
     Project project = Project.builder()
             .name(request.name())
             .user(owner)
             .isPublic(false)
                      .build();

     project = projectRepository.save(project);

    //  long userId = authUtil.getCurrentUserId();
        return projectMapper.toProjectResponse(project);
    }
    @Override
    public List<ProjectSummaryResponse> getUserProjects(long userId) {
        return List.of();
    }

    @Override
    public List<ProjectSummaryResponse> getUserProjectById(long id, long userId) {

        return List.of();
    }


    @Override
    public ProjectResponse updateProject(long id, ProjectRequest request, long userId) {
        Project project = projectRepository.findAccessibleProjectById(id,userId).orElseThrow();
        project.setName(request.name());
        project = projectRepository.save(project);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public void softDelete(long id, long userId) {
      Project project = getAccessibleProjectById(id,userId);
      if(!project.getUser().getId().equals(userId)){
         throw new RuntimeException("You are not allowed to delete");
      }
      project.setDeletedAt(Instant.now());
      projectRepository.save(project);
    }
    public Project getAccessibleProjectById(Long projectId,Long userId){
        return projectRepository.findAccessibleProjectById(projectId,userId).orElseThrow();

    }
}

