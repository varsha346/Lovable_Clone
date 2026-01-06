package com.lovable.demo.Service;

import com.lovable.demo.Dto.Project.ProjectRequest;
import com.lovable.demo.Dto.Project.ProjectResponse;
import com.lovable.demo.Dto.Project.ProjectSummaryResponse;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface ProjectService {

     List<ProjectSummaryResponse> getUserProjects(long userId);

     List<ProjectSummaryResponse> getUserProjectById(long id, long userId);

     ProjectResponse createProject(ProjectRequest request, long userId);
     ProjectResponse updateProject(long id, ProjectRequest request, long userId);

    void softDelete(long id, long userId);
}
