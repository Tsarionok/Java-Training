package by.tsarionok.dao;

import by.tsarionok.entity.Film;

import java.util.List;

public interface FilmDao extends Dao<Film> {
    List<Film> readAll(int page, int amountPerPage);

    List<Film> findByName(String name);

    List<Film> findByCategory(String category);

    Integer countFilms();
}
