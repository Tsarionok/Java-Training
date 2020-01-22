package by.tsarionok.dao;

public interface DaoFileManager {
    void create();

    void rename(String newName);

    String read();

    void update(byte[] data);

    void delete();
}
