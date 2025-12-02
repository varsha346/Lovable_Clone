package com.lovable.demo.Controller;
import com.lovable.demo.Dto.Project.*;
import com.lovable.demo.Service.FileService;
import com.lovable.demo.Service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/projects/{projectId}/files")
public class FileController {
private final FileService fileService;
@GetMapping
public ResponseEntity<List<FileNode>> getFileTree(@PathVariable long projectId){
    long userId = 1L;
    return ResponseEntity.ok(fileService.getFileTree(projectId,userId));
}


@GetMapping("/{*path}")
public ResponseEntity<FileContentResponse> getFile(
        @PathVariable long projectId,
        @PathVariable  String path
)
{
    long userId = 1L;
    return ResponseEntity.ok(fileService.getFileContent(projectId, path,userId));
}
}
