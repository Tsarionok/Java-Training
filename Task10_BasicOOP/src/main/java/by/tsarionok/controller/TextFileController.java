package by.tsarionok.controller;

import by.tsarionok.service.TextFileService;
import by.tsarionok.service.impl.TextFileServiceImpl;

public class TextFileController {

    private TextFileService fileService;

    public TextFileController(String path) {
        fileService = new TextFileServiceImpl(path);
    }

    void create() {
        fileService.create();
    }

    void rename() {
        fileService.rename();
    }

    String read() {
        return fileService.read();
    }

    void update() {
        fileService.update();
    }

    void delete() {
        fileService.delete();
    }


}
