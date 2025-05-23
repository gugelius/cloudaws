package com.example.task1_cloud.service.impl;

import com.example.task1_cloud.service.CSVService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class CSVServiceImpl implements CSVService {
    @Override
    public double calculateAverage(InputStream fileStream) throws IOException {
        List<Double> values = new ArrayList<>();
        try (CSVParser parser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(new InputStreamReader(fileStream))) {
            for (CSVRecord record : parser) {
                values.add(Double.parseDouble(record.get("value")));
            }
        }
        return values.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }
}
