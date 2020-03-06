package by.tsarionok.repository;

import by.tsarionok.repository.exception.RepositoryException;
import by.tsarionok.service.specification.Specification;

public interface Repository {

    void createMatrix(String path, String delimiter) throws RepositoryException;

    int[][] query(Specification specification) throws RepositoryException;

    void saveLastResult(String path) throws RepositoryException;
}
