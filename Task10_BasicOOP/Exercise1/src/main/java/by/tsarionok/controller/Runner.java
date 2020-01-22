package by.tsarionok.controller;

public class Runner {

    private static String PATH = "data/textData.txt";

    public static void main(String[] args) {
        ChooseController chooseController = new ChooseController();
        chooseController.fileAction(PATH);
    }
}
