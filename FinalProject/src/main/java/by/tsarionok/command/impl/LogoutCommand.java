package by.tsarionok.command.impl;

import by.tsarionok.command.ActionCommand;
import by.tsarionok.service.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty("path.page.index"); // уничтожение сессии
        request.getSession().invalidate();
        return page;
    }
}
