package by.tsarionok.dao;

import java.io.IOException;
import java.util.List;

public interface ArrayDao {
    List<String> readStringFile() throws IOException;

    void writeStringFile(List<String> numbers) throws IOException;
}
