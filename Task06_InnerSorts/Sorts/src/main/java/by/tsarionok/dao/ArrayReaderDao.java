package by.tsarionok.dao;

import java.io.IOException;
import java.util.List;

public interface ArrayReaderDao {
    List<String> readStringFile() throws IOException;
}
