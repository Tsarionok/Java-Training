package by.tsarionok.controller.command.manager;

import java.util.ResourceBundle;

public final class MessageManager {

    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
            .getBundle("messages");

    private MessageManager() {
    }

    public static String getProperty(final String key) {
        return RESOURCE_BUNDLE.getString(key);
    }
}
