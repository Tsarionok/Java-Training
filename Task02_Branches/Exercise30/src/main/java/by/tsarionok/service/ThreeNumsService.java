package by.tsarionok.service;

public class ThreeNumsService {
    double a;
    double b;
    double c;

    public ThreeNumsService(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void changeNums() {
        if (a > b && b > c) {
            a *= 2;
            b *= 2;
            c *= 2;
        } else {
            if (a < 0) {
                a = -a;
            }
            if (b < 0) {
                b = -b;
            }
            if (c < 0) {
                c = -c;
            }
        }
    }

    @Override
    public String toString() {
        return "a = " + a + ", b = " + b + ", c = " + c;
    }
}
