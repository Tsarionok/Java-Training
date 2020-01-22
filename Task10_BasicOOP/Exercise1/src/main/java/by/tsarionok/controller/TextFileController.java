package by.tsarionok.controller;

import by.tsarionok.service.TextFileService;
import by.tsarionok.service.impl.TextFileServiceImpl;

import java.util.Scanner;

public class TextFileController {

    private TextFileService fileService;

    public TextFileController(String path) {
        fileService = new TextFileServiceImpl(path);
    }

    void create() {
        fileService.create();
    }

    void rename(String newName) {
        fileService.rename(newName);
    }

    String read() {
        return fileService.read();
    }

    void update() {
        fileService.update(inputRequest());
    }

    void delete() {
        fileService.delete();
    }

    private String inputRequest() {
        System.out.println("Input data at file: ");
        Scanner scanner = new Scanner(System.in);
        return "\n" + scanner.nextLine();
    }

}
