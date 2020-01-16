package by.tsarionok.service;

public interface TextFileService {
    void create();

    void rename(String newName);

    String read();

    void update();

    void delete();
}
