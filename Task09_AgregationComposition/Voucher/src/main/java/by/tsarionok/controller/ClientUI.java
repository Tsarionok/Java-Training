package by.tsarionok.controller;

import java.util.Scanner;

public class ClientUI {
    private final static ClientUI INSTANCE = new ClientUI();

    private ClientUI() {

    }

    public static ClientUI getInstance() {
        return INSTANCE;
    }

    public int mainMenuChoose() {
        System.out.println("\n__________Main menu_________\n" +
                "1) Cruise;\n" +
                "2) Excursion;\n" +
                "3) Relax;\n" +
                "4) Therapy;\n" +
                "Please, select the type of voucher: ");
        return enterWithCheck();
    }

    public int cruiseChoose() {
        System.out.println("\n__________Cruise menu_________\n" +
                "1) Sea;\n" +
                "2) River;\n" +
                "Please, select the type of cruise: ");
        return enterWithCheck();
    }

    public int excursionChoose() {
        System.out.println("\n__________Excursion menu_________\n" +
                "1) One day;\n" +
                "2) Many days;\n" +
                "Please, select the type of excursion: ");
        return enterWithCheck();
    }

    public int relaxChoose() {
        System.out.println("\n__________Relax menu_________\n" +
                "1) Sea;\n" +
                "2) Mountains;\n" +
                "Please, select the place of relax: ");
        return enterWithCheck();
    }

    public int therapyChoose() {
        System.out.println("\n__________Therapy menu_________\n" +
                "1) Fitness;\n" +
                "2) SPA;\n" +
                "3) Weight loss therapy;\n" +
                "Please, select the type of therapy: ");
        return enterWithCheck();
    }

    public int foodChoise() {
        System.out.println("\n__________Food choose menu_________\n" +
                "1) Meat;\n" +
                "2) Fish;\n" +
                "3) Vegetables;\n" +
                "4) Fruits;\n" +
                "5) Eggs;\n" +
                "Please, select the type of food: ");
        return enterWithCheck();
    }

    public int transportChoise() {
        System.out.println("\n__________Transport choose menu_________\n" +
                "1) Car;\n" +
                "2) Plain;\n" +
                "3) Bus;\n" +
                "4) Liner;\n" +
                "Please, select the type of transport: ");
        return enterWithCheck();
    }

    public int daysEnter() {
        System.out.println("Enter number of days: ");
        return enterWithCheck();
    }

    public double costEnter() {
        System.out.println("Enter cost: ");
        return enterWithCheckDouble();
    }

    public int enterWithCheck() {
        Scanner input = new Scanner(System.in);

        while (!input.hasNextInt()) {
            System.out.print("This is not a natural number!\nEnter a natural number: ");
            input.next();
        }
        return input.nextInt();
    }

    public double enterWithCheckDouble() {
        Scanner input = new Scanner(System.in);

        while (!input.hasNextDouble()) {
            System.out.print("This is not a double number!\nEnter a double number: ");
            input.next();
        }
        return input.nextDouble();
    }
}
