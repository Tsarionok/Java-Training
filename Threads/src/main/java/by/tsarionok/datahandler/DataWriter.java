package by.tsarionok.datahandler;

import by.tsarionok.datahandler.exception.DataHandlerException;

public interface DataWriter {

    void writeFile(int[][] array, String path) throws
            DataHandlerException;
}
