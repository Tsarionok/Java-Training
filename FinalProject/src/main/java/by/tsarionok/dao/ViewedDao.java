package by.tsarionok.dao;

import by.tsarionok.entity.Viewed;

import java.util.List;

public interface ViewedDao {
    List<Viewed> readAllByUserId(Integer id,
                                 int pageNum,
                                 int amountPerPage);

    boolean updateViewingDate(Integer userId, Integer filmId);

    Integer findIdByUserAndFilmId(Integer userId, Integer filmId);

    Integer countFilms(int userId);
}
