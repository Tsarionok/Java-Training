package by.tsarionok.controller;

import by.tsarionok.entity.Entity;
import by.tsarionok.service.Parser;

import java.util.List;

public class ParseController {

    public List<Entity> parseDocument(final String filePath, final Parser parser) {
        parser.buildEntities(filePath);
        return parser.getEntities();
    }
}
