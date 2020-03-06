package by.tsarionok.controller;

import by.tsarionok.controller.command.Command;
import by.tsarionok.controller.command.CommandProvider;

public class Controller {

    private static final String DEL = " ";

    private final CommandProvider provider = new CommandProvider();

    public String executeTask(final String request) {
        String commandName;
        Command executionCommand;
        String response;
        String params = "";

        if (request.contains(DEL)) {
            commandName = request.substring(
                    0, request.indexOf(DEL));
            params = request.substring(request.indexOf(DEL) + 1)
                    .toLowerCase();
        } else {
            commandName = request;
        }

        executionCommand = provider.getCommand(commandName);
        response = executionCommand.execute(params);

        return response;
    }
}
