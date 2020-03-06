package by.tsarionok.datahandler;

import by.tsarionok.datahandler.exception.DataHandlerException;

import java.util.List;

public interface DataReader {

    List<String> readFile(String path) throws DataHandlerException;
}
