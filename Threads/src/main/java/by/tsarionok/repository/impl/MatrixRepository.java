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

public class MatrixRepository implements Repository {

    private int threadNumber;

    private int[] values;

    private int[][] array;

    private int[][] lastResult;

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
