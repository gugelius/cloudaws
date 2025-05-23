package com.example.task1_cloud.service;

import java.io.IOException;
import java.io.InputStream;

public interface CSVService {
    double calculateAverage(InputStream fileStream) throws IOException;
}
