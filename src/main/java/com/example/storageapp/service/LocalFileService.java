package com.example.storageapp.service;

import com.example.storageapp.exceptions.ConfigPropertyException;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class LocalFileService {

    public static final Logger logger = LoggerFactory.getLogger(LocalFileService.class);

    //@Value("${files.path}")
    private String uploads = "D:\\Programowanie\\Applications\\storage-app\\files\\";

    public LocalFileService() {
        try {
            createContextDirectory();
        } catch (ConfigPropertyException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createContextDirectory() throws ConfigPropertyException, IOException {
        if (Strings.isBlank(uploads)) {
            logger.error("Cannot get path to files");
            throw new ConfigPropertyException("Cannot get path to files");
        }

        Path path = Paths.get(uploads);
        if (Files.notExists(path)) {
            try {
                logger.info("Try to create directory: {}", path);
                Files.createDirectories(path);
            } catch (IOException e) {
                logger.error("Cannot create directory: {}. Exception: {}", path, e.getMessage());
                throw new IOException(e.getMessage());
            }
        }

    }

    public ResponseEntity<?> getFile(String filename) {
        Resource resource;
        Path path = Paths.get(uploads);
        try {
            resource = new UrlResource(path.toUri());
        } catch (MalformedURLException e) {
            logger.error("Cannot get file: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        File targetFile;
        try {
            targetFile = resource.getFile();
        } catch (IOException e){
            logger.error("Cannot get file: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        String contentType;
        try {
            contentType = Files.probeContentType(path);
        } catch (IOException e){
            logger.error("Cannot get file: {}", e.getMessage());
            // to inny przykład wykorzystania ResponseEntity
            return  ResponseEntity.ok().body(e.getMessage());
        }
        return ResponseEntity.ok().contentType(MediaType.
                parseMediaType(contentType)).
                header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment;filename=\"" + targetFile.getName() + "\"").
                contentLength(targetFile.length()).body(resource);
    }

}
