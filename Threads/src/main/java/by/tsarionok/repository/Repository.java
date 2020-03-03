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

    /**
     * Creates the matrix instance.
     *
     * @param path      the path to storage file.
     * @param delimiter the delimiter to parse the data from file.
     * @throws RepositoryException if error happens during execution.
     */
    void createMatrix(String path, String delimiter) throws
            RepositoryException;

    /**
     * Determines the business rules that applies to the matrix.
     *
     * @param specification the concrete specification that query different
     *                      types of actions.
     * @return the 2-d array of integers that main diagonal was filled by
     * provided values.
     * @throws RepositoryException if error happens during execution.
     */
    int[][] query(Specification specification) throws RepositoryException;

    /**
     * Saves the last result obtained after executing the any method
     * that fill the main diagonal.
     *
     * @param path the path to storage file.
     * @throws RepositoryException if error happens during execution.
     */
    void saveLastResult(String path) throws RepositoryException;
}
