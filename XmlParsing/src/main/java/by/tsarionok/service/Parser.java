package by.tsarionok.service;

import by.tsarionok.entity.Entity;

import java.util.ArrayList;
import java.util.List;

public abstract class Parser {
    private List<Entity> entities;

    public Parser() {
        this.entities = new ArrayList<>();
    }

    public abstract void buildEntities(final String filePath);

    public List<Entity> getEntities() {
        return entities;
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }
}
