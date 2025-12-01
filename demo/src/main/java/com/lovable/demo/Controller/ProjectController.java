package com.lovable.demo.Controller;

import com.lovable.demo.Dto.Project.ProjectRequest;
import com.lovable.demo.Dto.Project.ProjectResponse;
import com.lovable.demo.Dto.Project.ProjectSummaryResponse;
import com.lovable.demo.Service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/projects")
public class ProjectController {
private final ProjectService projectService;


@GetMapping
public ResponseEntity<List<ProjectSummaryResponse>>GetMyProjects(){
long userId = 1L;
return ResponseEntity.ok(projectService.getUserProjects(userId));
}

@GetMapping("/{id}")
public ResponseEntity<List<ProjectSummaryResponse>>GetProjectsByID(@PathVariable long id){
    long userId = 1L;
        return ResponseEntity.ok(projectService.getUserProjectById(id,userId));
    }


@PostMapping
public ResponseEntity<ProjectResponse>createProject(@RequestBody ProjectRequest request ){
    long userId = 1L;
    return ResponseEntity.status(HttpStatus.CREATED).body(projectService.createProject(request,userId));
}






}
