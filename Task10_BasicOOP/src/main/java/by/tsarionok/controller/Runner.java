package by.tsarionok.controller;

public class Runner {

    private static String PATH = "data/textData.txt";

    public static void main(String[] args) {
        TextFileController controller = new TextFileController(PATH);

        controller.create();
//        controller.read();
//        controller.rename();
//        controller.update();
//        controller.delete();
    }
}
