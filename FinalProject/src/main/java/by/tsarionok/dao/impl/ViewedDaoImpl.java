package by.tsarionok.dao.impl;

import by.tsarionok.dao.BaseDao;
import by.tsarionok.dao.ViewedDao;
import by.tsarionok.entity.Watched;

import java.util.List;

public class ViewedDaoImpl extends BaseDao implements ViewedDao {
    @Override
    public List<Watched> readAllByUserId(Integer id, int pageNum, int amountPerPage) {
        return null;
    }

    @Override
    public boolean updateViewingDate(Integer userId, Integer filmId) {
        return false;
    }

    @Override
    public Integer findIdByUserAndFilmId(Integer userId, Integer filmId) {
        return null;
    }

    @Override
    public Integer countFilms(int userId) {
        return null;
    }

    @Override
    public Watched findById(Integer id) {
        return null;
    }

    @Override
    public Integer create(Watched entity) {
        return null;
    }

    @Override
    public boolean update(Watched entity) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
