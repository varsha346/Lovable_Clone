package com.lovable.demo.Service.Impl;


import com.lovable.demo.Dto.Project.FileContentResponse;
import com.lovable.demo.Dto.Project.FileNode;
import com.lovable.demo.Service.FileService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FileServiceImpl implements FileService {



    @Override
    public List<FileNode> getFileTree(long projectId, long userId) {
        return List.of();
    }

    @Override
    public FileContentResponse getFileContent(long projectId, String path, long userId) {
        return null;
    }
}
