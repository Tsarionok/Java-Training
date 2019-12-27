package by.tsarionok.service;

import by.tsarionok.entity.Test1;

public class TestService {

    public void update(Test1 test, int a, int b) {
        test.setA(a);
        test.setB(b);
    }

    public int calcSum(Test1 test) {
        return test.getA() + test.getB() ;
    }

    public int findMax(Test1 test1) {
        return test1.getA() > test1.getB() ? test1.getA() : test1.getB();
    }


}
