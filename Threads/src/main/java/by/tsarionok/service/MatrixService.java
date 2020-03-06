package by.tsarionok.service;

import by.tsarionok.service.exception.ServiceException;

public interface MatrixService {

    void createMatrix(String path, String delimiter) throws ServiceException;

    int[][] fillBySeparateThreads() throws ServiceException;

    int[][] fillByLocks() throws ServiceException;

    int[][] fillByExecutorService() throws ServiceException;

    int[][] fillBySemaphore() throws ServiceException;

    void saveLastResult(String path) throws ServiceException;
}
