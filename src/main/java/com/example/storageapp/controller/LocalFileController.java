package com.example.storageapp.controller;

import com.example.storageapp.model.LocalFile;
import com.example.storageapp.service.LocalFileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.util.List;

@RestController
@CrossOrigin
//@RequestMapping("/api/v1") // podmieniona w application properties
public class LocalFileController {

    private LocalFileService localFileService;

    public LocalFileController(LocalFileService localFileService) {
        this.localFileService = localFileService;
    }

    @GetMapping("/files")
    public List<LocalFile> getFiles() {
        return localFileService.getFiles();
    }

    @GetMapping("files/download/{filename}")
    public ResponseEntity<?> getFile(@PathVariable String filename) {
        return localFileService.getFile(filename);
    }

    @GetMapping("files/delete/{filename}") //todo  @DeleteMapping
    public ResponseEntity<?> deleteFile(@PathVariable String filename) {
        return localFileService.deleteFile(filename);
    }

}
