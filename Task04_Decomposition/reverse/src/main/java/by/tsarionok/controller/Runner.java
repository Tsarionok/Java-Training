package by.tsarionok.controller;

import java.util.Random;

public class Runner {
    public static void main(String[] args) {
        final int N  = 5;
        int temp;
        int [] arr = new int [N];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt();
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        System.out.println("--------");

        for (int i = 0; i < arr.length / 2; i++) {
            temp = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = arr[i];
            arr[i] = temp;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
