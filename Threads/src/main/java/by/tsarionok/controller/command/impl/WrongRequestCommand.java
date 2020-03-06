package by.tsarionok.controller.command.impl;

import by.tsarionok.controller.command.Command;
import by.tsarionok.controller.command.manager.MessageManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WrongRequestCommand implements Command {

    private static final Logger LOGGER = LogManager.getLogger(
            WrongRequestCommand.class);

    @Override
    public String execute(final String request) {
        LOGGER.debug("The command not found or wrong!");
        return MessageManager.getProperty("message.wrong.request");
    }
}
