package by.tsarionok.service.impl;

import by.tsarionok.dao.DaoFileManager;
import by.tsarionok.dao.impl.DaoFileManagerImpl;
import by.tsarionok.entity.TextFile;
import by.tsarionok.service.TextFileService;

public class TextFileServiceImpl implements TextFileService {

    DaoFileManager fileManager;

    public TextFileServiceImpl(String path) {
        fileManager = new DaoFileManagerImpl(new TextFile(path));
    }

    @Override
    public void create() {
        fileManager.create();
    }

    @Override
    public void rename(String newName) {
        fileManager.rename(newName);
    }

    @Override
    public String read() {
        return fileManager.read();
    }

    @Override
    public void update(String strData) {
        fileManager.update(strData.getBytes());
    }

    @Override
    public void delete() {
        fileManager.delete();
    }
}
