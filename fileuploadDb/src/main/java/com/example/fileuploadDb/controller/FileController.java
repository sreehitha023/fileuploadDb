package com.example.fileuploadDb.controller;

import com.example.fileuploadDb.entity.File;
import com.example.fileuploadDb.entity.FileResponse;
import com.example.fileuploadDb.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
    FileService fileService;

    @PostMapping
    public FileResponse uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        return fileService.store(file);
    }

    @GetMapping("/{id}")
    public File getFile(@PathVariable String id) {

        return fileService.getFileById(id);

    }

    @GetMapping("/list")
    public List<FileResponse> getFileList(){
        return fileService.getFileList();
    }


}
