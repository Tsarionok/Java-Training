package by.tsarionok.view;

public class MenuView {

	public void mainMenu() {

		System.out.println("Press '1' to add candy to the gift");
		System.out.println("Press '2' to add package to the gift");
		System.out.println("Press '3' to display the content of the current gift");
		System.out.println("Press 'q' to exite");
	}

	public void invalidValue() {
		System.out.println("you entered an invalid value, try again");
	}

	public void howMany() {
		System.out.println("how many candies do you want to add?");
	}

	public void noSweets(int i) {
		System.out.println("there are no candies with number " + i + " in the store, try again");
	}

	public void noPack(int i) {
		System.out.println("there are no packeges with number " + i + " in the store, try again");
	}

}
