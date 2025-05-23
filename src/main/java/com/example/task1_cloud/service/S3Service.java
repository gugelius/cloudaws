package com.example.task1_cloud.service;

import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.s3.endpoints.internal.Value;

public interface S3Service {
    void uploadFile(String bucketName, String key, byte[] fileData);
}
