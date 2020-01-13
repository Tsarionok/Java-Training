package by.tsarionok.dao;

import by.tsarionok.exception.FileIsEmptyException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ArrayDaoImpl implements ArrayDao {
    /**
     * Logger, which used to log event.
     */
    private final static Logger LOGGER = LogManager.getLogger(ArrayDaoImpl.class);

    private Path path;

    /**
     * List of the file lines.
     */
    private List<String> strData;

    public ArrayDaoImpl(final String pathName) throws FileNotFoundException {
        if (pathName != null) {
            path = Paths.get(pathName);
        } else {
            throw new FileNotFoundException("Path argument is null");
        }

    }

    @Override
    public List<String> readStringFile() {
        try {
            strData = Files.readAllLines(path);
            if (strData.isEmpty()) {
                throw new FileIsEmptyException("File is empty");
            }
        } catch (IOException e) {
            LOGGER.error("File doesn't exist", e);
        } catch (FileIsEmptyException e) {
            LOGGER.error("File is empty", e);
        } catch (UncheckedIOException e) {
            LOGGER.error("File path is a directory", e);
        }
        return strData;
    }

    @Override
    public void writeStringFile(List<String> numbers) throws IOException {

    }
}
