package com.lovable.demo.Service;

import com.lovable.demo.Dto.Project.FileContentResponse;
import com.lovable.demo.Dto.Project.FileNode;
//import org.jspecify.annotations.Nullable;

import java.util.List;

public interface FileService {
       List<FileNode> getFileTree(long projectId, long userId);

     FileContentResponse getFileContent(long projectId, String path, long userId);
}
