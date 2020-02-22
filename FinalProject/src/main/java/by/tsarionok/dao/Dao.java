package by.tsarionok.dao;

import by.tsarionok.entity.Entity;

public interface Dao<T extends Entity> {
    T findById(Integer id);

    Integer create(T entity);

    boolean update(T entity);

    boolean delete(Integer id);
}
