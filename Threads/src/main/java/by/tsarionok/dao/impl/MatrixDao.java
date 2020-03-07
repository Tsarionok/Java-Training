package by.tsarionok.dao.impl;

import by.tsarionok.dao.Dao;
import by.tsarionok.dao.exception.DaoException;
import by.tsarionok.datahandler.DataReader;
import by.tsarionok.datahandler.DataWriter;
import by.tsarionok.datahandler.exception.DataHandlerException;
import by.tsarionok.datahandler.factory.DataHandlerFactory;
import by.tsarionok.datahandler.parser.DataParser;
import by.tsarionok.entity.Matrix;
import by.tsarionok.service.filler.Variant;

public class MatrixDao implements Dao {

    private int threadNumber;

    private int[] values;

    private int[][] array;

    private int[][] lastResult;

    @Override
    public void createMatrix(final String path, final String delimiter) throws
            DaoException {

        DataHandlerFactory factory = DataHandlerFactory.getInstance();
        DataReader reader = factory.getDataReader();

        Matrix matrix;
        try {
            matrix = new DataParser().parseData(reader.readFile(path), delimiter);

            threadNumber = matrix.getThreadNumber();
            values = matrix.getDiagValues();
            array = matrix.getArr();

        } catch (DataHandlerException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public int[][] query(final Variant variant) throws
            DaoException {

        if (threadNumber != 0 || values != null || array != null) {
            lastResult = variant.variant(threadNumber, values, array);
            return lastResult;
        } else {
            throw new DaoException("Error during query execution!"
                    + " The matrix parameters"
                    + " does not exist!");
        }
    }

    public void saveLastResult(final String path) throws DaoException {
        try {
            if (lastResult != null) {
                DataHandlerFactory factory = DataHandlerFactory.getInstance();
                DataWriter dataWriter = factory.getDataWriter();

                dataWriter.writeFile(lastResult, path);
            } else {
                throw new DaoException("The last result is empty!"
                        + " Run any method first!");
            }
        } catch (DataHandlerException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }
}
