package by.tsarionok.dao.impl;

import by.tsarionok.dao.DaoFileManager;
import by.tsarionok.entity.TextFile;

public class DaoFileManagerImpl implements DaoFileManager {

    TextFile textFile;

    public DaoFileManagerImpl(TextFile textFile) {
        this.textFile = textFile;
    }

    @Override
    public void create() {
        System.out.println("create");
    }

    @Override
    public void rename() {
        System.out.println("rename");
    }

    @Override
    public String read() {
        System.out.println("read");
        return null;
    }

    @Override
    public void update() {
        System.out.println("update");
    }

    @Override
    public void delete() {
        System.out.println("delete");
    }
}
