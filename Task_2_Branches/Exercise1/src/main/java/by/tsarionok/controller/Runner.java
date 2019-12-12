package by.tsarionok.controller;

import by.tsarionok.service.ComparatorForWriting;

public class Runner {
    public static void main(String[] args) {
        System.out.println(new ComparatorForWriting().writeComparing(1 < 2, 7, 8));
    }
}
