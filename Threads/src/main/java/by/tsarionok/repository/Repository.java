package by.tsarionok.repository;

import by.tsarionok.repository.exception.RepositoryException;
import by.tsarionok.repository.specification.Specification;


/**
 * Interface used to describe the common structure of the different types of
 * repositories.
 *
 * @author Sergey Tsarionok
 */
public interface Repository {

    void createMatrix(String path, String delimiter) throws
            RepositoryException;

    int[][] query(Specification specification) throws RepositoryException;

    void saveLastResult(String path) throws RepositoryException;
}
