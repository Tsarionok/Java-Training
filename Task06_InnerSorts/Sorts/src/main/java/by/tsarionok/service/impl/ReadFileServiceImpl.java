package by.tsarionok.service.impl;

import by.tsarionok.dao.ArrayReaderDao;
import by.tsarionok.dao.ArrayReaderDaoImpl;
import by.tsarionok.parser.DataParser;
import by.tsarionok.service.ReadFileService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFileServiceImpl implements ReadFileService {

    private static final Logger LOGGER = LogManager.getLogger(ReadFileServiceImpl.class);

    @Override
    public List<Double> readToNumbers(String path) {
        List<String> data = new ArrayList<>();
        try {
            ArrayReaderDao dao = new ArrayReaderDaoImpl(path);
            data = dao.readStringFile();
        } catch (FileNotFoundException e) {
            LOGGER.error("File is not exist on " + path);
        } catch (IOException e) {
            LOGGER.error(e);
        }
        DataParser parser = new DataParser();
        return parser.numberParser(data);
    }
}
