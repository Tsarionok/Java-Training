package by.tsarionok.controller.command.impl;

import by.tsarionok.controller.command.Command;
import by.tsarionok.controller.command.manager.MessageManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ExitCommand implements Command {

    private static final Logger LOGGER = LogManager.getLogger(
            ExitCommand.class);

    @Override
    public String execute(final String request) {
        LOGGER.debug("Exit from the application!");
        return MessageManager.getProperty("message.exit.correct");
    }
}
