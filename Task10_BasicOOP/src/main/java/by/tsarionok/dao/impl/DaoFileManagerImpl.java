package by.tsarionok.dao.impl;

import by.tsarionok.dao.DaoFileManager;
import by.tsarionok.entity.TextFile;
import by.tsarionok.exception.FileExistsException;
import by.tsarionok.exception.FileIsEmptyException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

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
        StringBuilder data = new StringBuilder();
        try {
            Files.lines(Paths.get(textFile.getPath())).forEach(
                    s -> {
                        data.append(s);
                        data.append("\n");
                    });
            if (data.toString().isEmpty()) {
                throw new FileIsEmptyException("File is empty");
            }
        } catch (IOException e) {
            LOGGER.error("File doesn't exist", e);
        } catch (FileIsEmptyException e) {
            LOGGER.error("File is empty", e);
        } catch (UncheckedIOException e) {
            LOGGER.error("File path is a directory", e);
        }
        return new String(data);
    }

    @Override
    public void update(byte[] data) {
        try {
            Files.write(textFile.toPath(), data, StandardOpenOption.APPEND);
        } catch (IOException e) {
            LOGGER.error("File doesn't exist", e);
        }
    }

    @Override
    public void delete() {
        textFile.delete();
    }
}
