package by.tsarionok.dao.impl;

import by.tsarionok.entity.Serial;
import org.junit.Test;

import java.util.List;

public class SerialDaoImplTest {

    private SerialDaoImpl serialDao;

    public SerialDaoImplTest() {
        this.serialDao = new SerialDaoImpl();
    }

    @Test
    public void readAll() {
        List<Serial> serials;
        serials = serialDao.readAll(2, 2);
        System.out.println(serials);
    }

    @Test
    public void findByName() {
        List<Serial> serials;
        serials = serialDao.findByName("Шерлок");
        System.out.println(serials);
    }
}
