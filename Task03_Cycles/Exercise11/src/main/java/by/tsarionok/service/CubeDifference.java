package by.tsarionok.service;

public class CubeDifference {

    public void showDifference() {
        for (int i = 1; i < 201; i++) {
            for (int j = 1; j < 201; j++) {
                System.out.println(calculateCubesDiff(i, j));
            }
        }
    }

    public String calculateCubesDiff(int a, int b) {
        return a + "^3 - " + b + "^3 = " + (a * a * a - b * b * b);
    }

}
