package by.tsarionok.dao.impl;

import by.tsarionok.dao.DaoFileManager;
import by.tsarionok.entity.TextFile;
import by.tsarionok.exception.FileExistsException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class DaoFileManagerImpl implements DaoFileManager {
    private static final Logger LOGGER = LogManager.getLogger(DaoFileManagerImpl.class);

    TextFile textFile;

    public DaoFileManagerImpl(TextFile textFile) {
        this.textFile = textFile;
    }

    @Override
    public void create() {
        try {
            if (!textFile.exists()) {
                textFile.createNewFile();
            } else {
                throw new FileExistsException();
            }
        } catch (IOException e) {
            LOGGER.error("Incorrect path");
        } catch (FileExistsException e) {
            LOGGER.error("Creating error! This file is exists");
        }

    }

    @Override
    public void rename(String newName) {
        textFile.renameTo(new File(newName));
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
