package com.lovable.demo.Service;

import com.lovable.demo.Dto.Project.ProjectRequest;
import com.lovable.demo.Dto.Project.ProjectResponse;
import com.lovable.demo.Dto.Project.ProjectSummaryResponse;
//import org.jspecify.annotations.Nullable;

import java.util.List;

public interface ProjectService {

     List<ProjectSummaryResponse> getUserProjects();

     ProjectResponse getUserProjectById(long id);

     ProjectResponse createProject(ProjectRequest request);
     ProjectResponse updateProject(long id, ProjectRequest request);

    void softDelete(long id);


}
