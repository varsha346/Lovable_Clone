package com.lovable.demo.mapper;

import com.lovable.demo.Dto.Auth.UserProfileResponse;
import com.lovable.demo.Dto.Project.ProjectResponse;
import com.lovable.demo.Dto.Project.ProjectSummaryResponse;
import com.lovable.demo.entity.Project;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-23T14:52:09+0530",
    comments = "version: 1.6.0, compiler: javac, environment: Java 24.0.2 (Oracle Corporation)"
)
@Component
public class ProjectMapperImpl implements ProjectMapper {

    @Override
    public ProjectResponse toProjectResponse(Project project) {
        if ( project == null ) {
            return null;
        }

        long id = 0L;
        String name = null;
        Instant createdAt = null;
        Instant updatedAt = null;

        if ( project.getId() != null ) {
            id = project.getId();
        }
        name = project.getName();
        createdAt = project.getCreatedAt();
        updatedAt = project.getUpdatedAt();

        UserProfileResponse owner = null;

        ProjectResponse projectResponse = new ProjectResponse( id, name, createdAt, updatedAt, owner );

        return projectResponse;
    }

    @Override
    public ProjectSummaryResponse toProjectSummaryResponse(Project project) {
        if ( project == null ) {
            return null;
        }

        String name = null;
        long id = 0L;
        Instant createdAt = null;
        Instant updatedAt = null;

        name = project.getName();
        if ( project.getId() != null ) {
            id = project.getId();
        }
        createdAt = project.getCreatedAt();
        updatedAt = project.getUpdatedAt();

        ProjectSummaryResponse projectSummaryResponse = new ProjectSummaryResponse( id, name, createdAt, updatedAt );

        return projectSummaryResponse;
    }

    @Override
    public List<ProjectSummaryResponse> toListOfProjectSummaryResponse(List<Project> projects) {
        if ( projects == null ) {
            return null;
        }

        List<ProjectSummaryResponse> list = new ArrayList<ProjectSummaryResponse>( projects.size() );
        for ( Project project : projects ) {
            list.add( toProjectSummaryResponse( project ) );
        }

        return list;
    }
}
