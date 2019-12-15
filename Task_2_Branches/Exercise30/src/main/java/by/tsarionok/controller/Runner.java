package by.tsarionok.controller;

import by.tsarionok.service.ThreeNumsService;

public class Runner {
    public static void main(String[] args) {
        ThreeNumsService service = new ThreeNumsService(4.6, 4.5, 2);
        System.out.println(service);
        service.changeNums();
        System.out.println(service);
    }
}
