package by.tsarionok.controller;

import java.util.Random;

public class Runner {
    public static void main(String[] args) {
        final int N = 10;
        int arr[] = new int[N];
        Random random = new Random();

        for (int i = 0; i < N; i++) {
            arr[i] = random.nextInt();
        }

        for (int i = 0; i < N; i++) {
            System.out.println(arr[i]);
        }

        int temp;
        // влево или вправо с флажком
        for (int j = 0; j < 2; j++) {
            for (int i = N - 1; i >= 0; i--) {
                temp = arr[i];
                arr[i] =
            }
        }
    }
}
