package by.tsarionok.controller.command;

import by.tsarionok.controller.command.impl.*;

import java.util.EnumMap;
import java.util.Map;

public class CommandProvider {

    private final Map<CommandName, Command> repository = new EnumMap<>(CommandName.class);

    public CommandProvider() {
        repository.put(CommandName.CREATE_MATRIX, new CreateMatrixCommand());
        repository.put(CommandName.THREAD_DISTRIBUTION, new ThreadDistributionCommand());
        repository.put(CommandName.LOCK, new LockCommand());
        repository.put(CommandName.EXECUTOR_SERVICE, new ExecutorServiceCommand());
        repository.put(CommandName.SEMAPHORE, new SemaphoreCommand());
        repository.put(CommandName.SAVE_LAST, new SaveLastCommand());
        repository.put(CommandName.EXIT, new ExitCommand());
        repository.put(CommandName.WRONG_REQUEST, new WrongRequestCommand());
    }

    public Command getCommand(final String code) {
        Command command;

        try {
            command = repository.get(CommandName.values()[Integer.parseInt(code) - 1]);
        } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
            command = repository.get(CommandName.WRONG_REQUEST);
        }
        return command;
    }
}
