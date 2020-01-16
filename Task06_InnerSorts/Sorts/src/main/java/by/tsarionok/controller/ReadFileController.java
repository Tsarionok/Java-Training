package by.tsarionok.controller;

import by.tsarionok.service.ReadFileService;
import by.tsarionok.service.impl.ReadFileServiceImpl;

import java.util.List;

public class ReadFileController {
    public List<Double> readFile(String path) {
        ReadFileService readFileService = new ReadFileServiceImpl();
        List<Double> nums;
        nums = readFileService.readToNumbers(path);
        return nums;
    }
}
