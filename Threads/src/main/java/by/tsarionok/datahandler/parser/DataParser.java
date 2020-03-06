package by.tsarionok.datahandler.parser;

import by.tsarionok.bean.Matrix;
import by.tsarionok.datahandler.exception.DataHandlerException;
import by.tsarionok.service.validator.Validator;

import java.util.Arrays;
import java.util.List;

public class DataParser {

    private Validator validator;

    public DataParser() {
        validator = new Validator();
    }

    public Matrix parseData(final List<String> data,
                            final String delimiter) throws DataHandlerException {

        int threadNumber = getThreadNumber(data);

        int[] diagValue = getDiagInts(data, delimiter);

        int[][] ints = getMatrixInts(data.subList(2, data.size()), delimiter);

        if (!validator.isValidThreadNumber(threadNumber)
                || validator.isValidDiagValues(diagValue, threadNumber)) {
            String message = String.format(
                    "The thread number: %d or the number of thread values: "
                            + "%s are not valid!", threadNumber,
                    Arrays.toString(diagValue));
            throw new DataHandlerException(message);
        } else {
            return Matrix.getInstance(threadNumber, diagValue, ints);
        }
    }

    private int[][] getMatrixInts(final List<String> subList,
                                  final String delimiter) throws DataHandlerException {

        if (validator.isSquareMatrix(subList, delimiter)) {

            int n = subList.size();
            if (!validator.isValidDimension(n)) {
                String message = String.format(
                        "The dimension of the matrix in the file is invalid:"
                                + " %d", n);
                throw new DataHandlerException(message);
            }

            return getArr(subList, delimiter, n);
        } else {
            String message = "The data in the file is not square matrix!";
            throw new DataHandlerException(message);
        }
    }

    private int[][] getArr(final List<String> subList, final String delimiter,
                           final int n) throws DataHandlerException {

        int[][] arr = new int[n][n];
        for (int i = 0; i < subList.size(); i++) {

            String[] row = subList.get(i).split(delimiter);
            if (validator.isValidDiagonalValue(row[i])) {
                String message = String.format(
                        "The diagonal value for the matrix in the file is "
                                + "not equal to 0: %s", row[i]);
                throw new DataHandlerException(message);
            }

            for (int j = 0; j < row.length; j++) {
                if (validator.isNumber(row[j])) {
                    arr[i][j] = Integer.parseInt(row[j]);
                } else {
                    String message = String.format(
                            "The values for the matrix in the file are "
                                    + "invalid: %s", row[j]);
                    throw new DataHandlerException(message);
                }
            }
        }
        return arr;
    }

    private int[] getDiagInts(final List<String> data,
                              final String delimiter) throws DataHandlerException {

        String[] diagArrStrings = data.get(1).split(delimiter);

        int[] diagArrInts = new int[diagArrStrings.length];

        for (int i = 0; i < diagArrStrings.length; i++) {
            String s = diagArrStrings[i];
            if (validator.isNumber(s)) {
                diagArrInts[i] = Integer.parseInt(s);
            } else {
                String message = String.format(
                        "The diagonal values in the file are invalid: %s", s);
                throw new DataHandlerException(message);
            }
        }
        return diagArrInts;
    }

    private int getThreadNumber(final List<String> data) throws
            DataHandlerException {

        String threadNumStr = data.get(0).trim();

        if (validator.isNumber(threadNumStr)) {
            return Integer.parseInt(threadNumStr);
        } else {
            String message = String.format(
                    "The thread number in the file contains invalid data: %s",
                    threadNumStr);
            throw new DataHandlerException(message);
        }
    }
}
