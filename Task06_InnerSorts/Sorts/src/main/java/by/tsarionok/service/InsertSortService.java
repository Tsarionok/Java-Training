package by.tsarionok.service;

import java.util.ArrayList;

public class InsertSortService {

    public void sort(ArrayList<Integer> arr) {
        int temp;
        int min = Integer.MAX_VALUE;
        int rightBorder = 0;
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i; j < arr.size(); j++) {
                if (min > arr.get(j)) {
                    min = arr.get(j);
                    rightBorder = j;
                }
                for (int k = i; i < rightBorder; k++) {
                    temp = arr.get(k);
                    arr.set(k, arr.get(k + 1));
                    arr.set(k + 1, arr.get(k));
                }
            }

        }
    }

    public void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

}
