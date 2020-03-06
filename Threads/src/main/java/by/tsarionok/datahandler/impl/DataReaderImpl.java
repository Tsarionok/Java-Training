package by.tsarionok.datahandler.impl;

import by.tsarionok.datahandler.DataReader;
import by.tsarionok.datahandler.exception.DataHandlerException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataReaderImpl implements DataReader {

    @Override
    public List<String> readFile(final String path) throws
            DataHandlerException {

        List<String> stringList;

        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            stringList = stream.filter(line -> !line.isEmpty()).collect(
                    Collectors.toList());
        } catch (FileNotFoundException e) {
            String message = "File not found.";
            throw new DataHandlerException(message, e);
        } catch (IOException e) {
            String message = "Error during reading the file.";
            throw new DataHandlerException(message, e);
        }

        if (stringList.isEmpty()) {
            String message = "The file is empty!";
            throw new DataHandlerException(message);
        } else {
            return stringList;
        }
    }
}
