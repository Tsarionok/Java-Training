package by.tsarionok.entity;

import by.tsarionok.command.ActionCommand;
import by.tsarionok.command.impl.LoginCommand;
import by.tsarionok.command.impl.LogoutCommand;

public enum CommandEnum {
    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },
    LOGOUT {
        {
            this.command = new LogoutCommand();
        }
    };
    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
