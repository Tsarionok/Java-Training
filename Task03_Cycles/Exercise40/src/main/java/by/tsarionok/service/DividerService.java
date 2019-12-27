package by.tsarionok.service;

public class DividerService {
    public void getDividers(final int number) {
        int tempNum;
        int digit;
        boolean isDivide;
        for (int i = 1; i <= number; i++) {
            tempNum = i;
            isDivide = true;

            while (tempNum > 0) {
                digit = tempNum % 10;

                if (digit == 0 || i % digit == 0) {
                    tempNum /= 10;
                } else {
                    isDivide = false;
                    break;
                }
            }

            if (isDivide) {
                System.out.println(i);
            }
        }
    }
}
