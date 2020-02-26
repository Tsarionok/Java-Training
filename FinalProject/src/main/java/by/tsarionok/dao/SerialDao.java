package by.tsarionok.dao;

import by.tsarionok.entity.Serial;

import java.util.List;

public interface SerialDao extends Dao<Serial> {
    List<Serial> readAll(int page, int amountPerPage);

    List<Serial> findByName(String name);

    List<Serial> findByCategory(String category);

    Integer countFilms();
}
