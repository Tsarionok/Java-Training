package by.tsarionok.service;

import java.util.List;

public interface SortService<T extends Number> extends Comparable {
    List<T> sort();
}
