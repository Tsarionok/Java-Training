package by.tsarionok.controller;

import by.tsarionok.service.PrimaryNumService;

public class Runner {
    public static void main(String[] args) {
        int N = 30;
        PrimaryNumService service = new PrimaryNumService();
        System.out.println(service.allTwins(N, 2 * N));
    }
}
