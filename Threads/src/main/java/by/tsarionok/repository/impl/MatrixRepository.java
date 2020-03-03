package by.tsarionok.repository.impl;

import by.tsarionok.bean.Matrix;
import by.tsarionok.datahandler.DataReader;
import by.tsarionok.datahandler.DataWriter;
import by.tsarionok.datahandler.exception.DataHandlerException;
import by.tsarionok.datahandler.factory.DataHandlerFactory;
import by.tsarionok.datahandler.parser.DataParser;
import by.tsarionok.repository.Repository;
import by.tsarionok.repository.exception.RepositoryException;
import by.tsarionok.repository.specification.Specification;

/**
 * The repository interface implementation. Used to processing queries from
 * Services layer and applying to the matrix instance.
 *
 * @author Sergey Tsarionok
 */
public class MatrixRepository implements Repository {

    /**
     * The number of active threads to use.
     */
    private int threadNumber;

    /**
     * The array of values used to write to the main diagonal of the storage
     * array.
     */
    private int[] values;

    /**
     * The main storage that contains array of integers to fill by values.
     */
    private int[][] array;

    /**
     * The last received result of 2d array with filled main diagonal.
     */
    private int[][] lastResult;

    /**
     * Creates the matrix.
     *
     * @param path      the path to storage file.
     * @param delimiter the delimiter to parse the data from file.
     * @throws RepositoryException if error happens during execution.
     */
    @Override
    public void createMatrix(final String path, final String delimiter) throws
            RepositoryException {

        DataHandlerFactory factory = DataHandlerFactory.getInstance();
        DataReader reader = factory.getDataReader();

        Matrix matrix;
        try {
            matrix = new DataParser().parseData(reader.readFile(path),
                    delimiter);

            threadNumber = matrix.getThreadNumber();
            values = matrix.getDiagValues();
            array = matrix.getArr();

        } catch (DataHandlerException e) {
            throw new RepositoryException(e.getMessage(), e);
        }
    }

    /**
     * Determines the business rules that applies to the matrix.
     *
     * @param specification the concrete specification that query different
     *                      types of actions.
     * @return the 2-d array of integers that main diagonal was filled by
     * provided values.
     * @throws RepositoryException if error happens during execution.
     */
    @Override
    public int[][] query(final Specification specification) throws
            RepositoryException {

        if (threadNumber != 0 || values != null || array != null) {
            lastResult = specification.specified(threadNumber, values, array);
            return lastResult;
        } else {
            throw new RepositoryException("Error during query execution!"
                    + " The matrix parameters"
                    + " does not exist!");
        }
    }

    /**
     * Saves the last result obtained after executing the any method
     * that fill the main diagonal.
     *
     * @param path the path to storage file.
     * @throws RepositoryException if error happens during execution.
     */
    public void saveLastResult(final String path) throws RepositoryException {
        try {
            if (lastResult != null) {
                DataHandlerFactory factory = DataHandlerFactory.getInstance();
                DataWriter dataWriter = factory.getDataWriter();

                dataWriter.writeFile(lastResult, path);
            } else {
                throw new RepositoryException("The last result is empty!"
                        + " Run any method first!");
            }
        } catch (DataHandlerException e) {
            throw new RepositoryException(e.getMessage(), e);
        }
    }
}
