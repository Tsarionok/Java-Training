package by.tsarionok.service;

import by.tsarionok.entity.Shop;
import by.tsarionok.view.MenuView;

import java.util.Scanner;

public class ScannerLogic {

	private static MenuView mView = new MenuView();

	public static String getMainMenuChoice() {

		while (true) {

			String choice = getChoice().replaceAll(" ", "");

			if (choice.matches("[123q]") && choice.length() == 1) {
				return choice;
			} else {
				mView.invalidValue();
			}
		}
	}

	public static int getPackChoice(Shop shop) {

		while (true) {

			int choice = getNumberChoice() - 1;

			if ((choice) >= 0 && (choice) < shop.getPacks().size()) {
				return choice;
			} else {
				mView.noPack(choice + 1);
			}
		}
	}

	public static int getSweetChoice(Shop shop) {

		while (true) {

			int choice = getNumberChoice() - 1;

			if (choice >= 0 && choice < shop.getSweets().size()) {
				return choice;
			} else {
				mView.noSweets(choice + 1);
			}
		}
	}

	public static int getNumberChoice() {

		while (true) {

			String choice = getChoice().replaceAll(" ", "");

			if (choice.matches("\\s*[0-9]+\\s*") && choice.length() < 10) {
				return Integer.valueOf(choice);
			} else {
				mView.invalidValue();
			}
		}
	}

	private static String getChoice() {

		String choice;

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		choice = scanner.nextLine();

		return choice;
	}
}
