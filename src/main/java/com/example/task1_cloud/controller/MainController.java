package com.example.task1_cloud.controller;

import com.example.task1_cloud.service.CSVService;
import com.example.task1_cloud.service.S3Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class MainController {
    private final S3Service s3Service;
    private final CSVService csvService;
    public MainController(S3Service s3Service, CSVService csvService){
        this.s3Service = s3Service;
        this.csvService = csvService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        s3Service.uploadFile("my-bucket", file.getOriginalFilename(), file.getBytes());

        // Анализ загруженного файла
        double avg = csvService.calculateAverage(file.getInputStream());
        return ResponseEntity.ok("Файл загружен: " + file.getOriginalFilename() + ", Среднее значение: " + avg);
    }

}
