package by.tsarionok.dao;

import by.tsarionok.entity.Watched;

import java.util.List;

public interface ViewedDao extends Dao<Watched> {
    List<Watched> readAllByUserId(Integer id,
                                  int pageNum,
                                  int amountPerPage);

    boolean updateViewingDate(Integer userId, Integer filmId);

    Integer findIdByUserAndFilmId(Integer userId, Integer filmId);

    Integer countFilms(int userId);
}
