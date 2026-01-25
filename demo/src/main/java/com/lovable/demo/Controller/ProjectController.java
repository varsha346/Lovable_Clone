package com.lovable.demo.Controller;

import com.lovable.demo.Dto.Project.ProjectRequest;
import com.lovable.demo.Dto.Project.ProjectResponse;
import com.lovable.demo.Dto.Project.ProjectSummaryResponse;
import com.lovable.demo.Service.ProjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/projects")
public class ProjectController {
private final ProjectService projectService;


@GetMapping
public ResponseEntity<List<ProjectSummaryResponse>>GetMyProjects(){
long userId = 1L;
return ResponseEntity.ok(projectService.getUserProjects());
}

@GetMapping("/{id}")
public ResponseEntity<ProjectResponse>GetProjectsByID(@PathVariable long id){
    long userId = 1L;
        return ResponseEntity.ok(projectService.getUserProjectById(id));
    }


@PostMapping
public ResponseEntity<ProjectResponse>createProject(@RequestBody @Valid ProjectRequest request ){
    long userId = 1L;
    log.info("create order request initiated");

    try {
        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.createProject(request));
    }
    catch(Exception e ) {
        log.error("error is ",e);
    }
    return ResponseEntity.noContent().build();

}

@PatchMapping("/{id}")
public ResponseEntity<ProjectResponse> updateProject(@PathVariable long id, @RequestBody @Valid ProjectRequest request) {
    long userId = 1L;
    return ResponseEntity.ok(projectService.updateProject(id,request));
}


@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteProject(@PathVariable long id ){
    long userId = 1L;
    projectService.softDelete(id);
    return ResponseEntity.noContent().build();
}








}
