package by.tsarionok.dao.impl;

import by.tsarionok.dao.BaseDao;
import by.tsarionok.dao.SeeLaterDao;
import by.tsarionok.entity.SeeLater;

import java.util.List;

public class SeeLaterDaoImpl extends BaseDao implements SeeLaterDao {
    @Override
    public List<SeeLater> readAllByUserId(Integer id, int pageNum, int amountPerPage) {
        return null;
    }

    @Override
    public List<SeeLater> readAllByUserId(Integer userId) {
        return null;
    }

    @Override
    public boolean deleteByUserAndFilmId(Integer userId, Integer filmId) {
        return false;
    }

    @Override
    public Integer countFilms(int userId) {
        return null;
    }

    @Override
    public SeeLater findById(Integer id) {
        return null;
    }

    @Override
    public Integer create(SeeLater entity) {
        return null;
    }

    @Override
    public boolean update(SeeLater entity) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
