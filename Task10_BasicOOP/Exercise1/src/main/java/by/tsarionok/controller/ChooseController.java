package by.tsarionok.controller;

import java.util.Scanner;

public class ChooseController {
    public void fileAction(final String PATH) {
        TextFileController controller = new TextFileController(PATH);
        System.out.println("What do you want:\n" +
                "1) Create new file;\n" +
                "2) Rename existing file;\n" +
                "3) Read file;\n" +
                "4) Append info at file;\n" +
                "5) Delete file.");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()) {
            case 1:
                controller.create();
                break;
            case 2:
                controller.rename("noName.txt");
                break;
            case 3:
                System.out.println(controller.read());
                break;
            case 4:
                controller.update();
                break;
            case 5:
                controller.delete();
                break;
            default:

        }
    }
}
