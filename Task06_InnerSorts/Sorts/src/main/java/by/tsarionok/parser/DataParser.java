package by.tsarionok.parser;

import java.util.ArrayList;
import java.util.List;

public class DataParser {
    private static final String SPLIT_PATTERN = "\\s+";

    public List<Double> numberParser(List<String> filteredList) {
        List<Double> sortedList = new ArrayList<>();
        for (String line : filteredList) {
            sortedList.add(Double.parseDouble(line));
        }
        return sortedList;
    }

}
