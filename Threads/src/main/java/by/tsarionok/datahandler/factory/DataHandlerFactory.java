package by.tsarionok.datahandler.factory;

import by.tsarionok.datahandler.DataReader;
import by.tsarionok.datahandler.DataWriter;
import by.tsarionok.datahandler.impl.DataReaderImpl;
import by.tsarionok.datahandler.impl.DataWriterImpl;

public final class DataHandlerFactory {

    private static DataHandlerFactory instance = new DataHandlerFactory();

    private final DataReader dataReader = new DataReaderImpl();

    private final DataWriter dataWriter = new DataWriterImpl();

    private DataHandlerFactory() {
    }

    public static DataHandlerFactory getInstance() {
        return instance;
    }

    public DataReader getDataReader() {
        return dataReader;
    }

    public DataWriter getDataWriter() {
        return dataWriter;
    }
}
