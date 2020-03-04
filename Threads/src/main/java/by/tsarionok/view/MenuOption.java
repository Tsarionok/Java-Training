package by.tsarionok.view;

public class MenuOption {

    private String title;

    MenuOption(final String titleValue) {
        this.title = titleValue;
    }

    String getTitle() {
        return title;
    }

    public void setTitle(final String titleValue) {
        this.title = titleValue;
    }
}
