package by.tsarionok.controller;

import by.tsarionok.service.DividerService;

public class Runner {
    public static void main(String[] args) {
        DividerService service = new DividerService();
        service.getDividers(1000);
    }
}
