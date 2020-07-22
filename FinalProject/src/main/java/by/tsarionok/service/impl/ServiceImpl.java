package by.tsarionok.service.impl;

import by.tsarionok.dao.DaoManager;

public abstract class ServiceImpl {
    DaoManager daoManager;

    void setDaoManager(final DaoManager manager) {
        this.daoManager = manager;
    }
}
