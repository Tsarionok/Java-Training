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

    private List<MenuOption> options = new ArrayList<>();


    private boolean isExit = false;

    public Menu() {
        controller = new Controller();
        fillMenu();
    }


    public void run() {
        while (!isExit) {
            printMenu();
            Scanner scanner = new Scanner(System.in);
            //scanner.useDelimiter("\\Z");
            String query = scanner.nextLine();

            if (!query.isEmpty() && (query.startsWith("7"))) {
                isExit = true;
            }

            String response = controller.executeTask(query);

            LOGGER.debug(response);
        }
    }

    private void addEntry(final MenuOption option) {
        options.add(option);
    }

    private void printMenu() {
        StringBuilder builder = new StringBuilder();

        builder.append("\nMenu:\n");
        builder.append("Type \"Number_of_the_command pattern\" to run:\n");

        for (int i = 0; i < options.size(); i++) {
            MenuOption entry = options.get(i);
            String optionFormatted = String.format(MENU_PATTERN, (i + 1), entry.getTitle());
            builder.append(optionFormatted);
        }

        String menu = builder.toString();
        LOGGER.debug(menu);
    }

    private void fillMenu() {
        addEntry(new MenuOption("Create the matrix."));
        addEntry(new MenuOption("Fill the matrix using index distribution."));
        addEntry(new MenuOption("Fill the matrix using concurrent locks."));
        addEntry(new MenuOption("Fill the matrix using executor service."));
        addEntry(new MenuOption("Fill the matrix using semaphore."));
        addEntry(new MenuOption("Save result."));
        addEntry(new MenuOption("Exit."));
    }
}
