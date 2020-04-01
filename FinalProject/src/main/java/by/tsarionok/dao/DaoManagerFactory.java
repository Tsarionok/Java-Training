package by.tsarionok.dao;

public interface DaoManagerFactory {
    DaoManager createAndGetManager();

    void close();
}
