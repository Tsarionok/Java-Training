package by.tsarionok.view;

import by.tsarionok.controller.Controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private static final Logger LOGGER = LogManager.getLogger(Menu.class);

    private static final String MENU_PATTERN = "%s - %s\n";

    private Controller controller;

    private List<MenuOption> entries = new ArrayList<>();


    private boolean isExit = false;

    public Menu() {
        controller = new Controller();
        fillMenu();
    }


    public void run() {
        while (!isExit) {
            printMenu();
            Scanner scanner = new Scanner(System.in);
            scanner.useDelimiter("\\Z");
            String query = scanner.nextLine();

            if (!query.isEmpty() && (query.startsWith("7"))) {
                isExit = true;
            }

            String response = controller.executeTask(query);

            LOGGER.debug(response);
        }
    }

    private void addEntry(final MenuOption entry) {
        entries.add(entry);
    }

    private void printMenu() {
        StringBuilder builder = new StringBuilder();

        builder.append("\nMenu:\n");
        builder.append("Type \"Number_of_the_command pattern\" to run:\n");

        for (int i = 0; i < entries.size(); i++) {
            MenuOption entry = entries.get(i);
            String entryFormatted = String.format(
                    MENU_PATTERN, (i + 1), entry.getTitle());
            builder.append(entryFormatted);
        }

        String menu = builder.toString();
        LOGGER.debug(menu);
    }

    private void fillMenu() {
        addEntry(new MenuOption("Create the matrix. Pattern: path delimiter."
                + " Example: \"1 data\\input.txt  \""));
        addEntry(new MenuOption("Fill the matrix using index distribution."));
        addEntry(new MenuOption("Fill the matrix using concurrent locks."));
        addEntry(new MenuOption("Fill the matrix using executor service."));
        addEntry(new MenuOption("Fill the matrix using semaphore."));
        addEntry(new MenuOption("Save last result. Pattern: path."
                + " Example: \"6 data\\output.txt\""));
        addEntry(new MenuOption("Exit."));
    }
}
