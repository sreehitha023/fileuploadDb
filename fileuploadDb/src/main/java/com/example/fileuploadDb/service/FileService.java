package com.example.fileuploadDb.service;

import com.example.fileuploadDb.entity.File;
import com.example.fileuploadDb.entity.FileResponse;
import com.example.fileuploadDb.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class FileService {
    @Autowired
    FileRepository fileRepository;

    public FileResponse store(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        File ModelFile = new File(UUID.randomUUID().toString(),fileName,file.getContentType(),file.getBytes());
        fileRepository.save(ModelFile);
        return mapToFileResponse(ModelFile);
    }

    public File getFileById(String id) {

        Optional<File> fileOptional = fileRepository.findById(id);

        if(fileOptional.isPresent()) {
            return fileOptional.get();
        }
        return null;
    }

    public List<FileResponse> getFileList(){
        return fileRepository.findAll().stream().map(this::mapToFileResponse).collect(Collectors.toList());
    }

    private FileResponse mapToFileResponse(File modelFile) {
        return new FileResponse(modelFile.getId(), modelFile.getType(), modelFile.getName());
    }
}
