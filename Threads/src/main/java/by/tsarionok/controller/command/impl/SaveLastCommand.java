package by.tsarionok.controller.command.impl;

import by.tsarionok.controller.command.Command;
import by.tsarionok.controller.command.manager.MessageManager;
import by.tsarionok.service.MatrixService;
import by.tsarionok.service.exception.ServiceException;
import by.tsarionok.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SaveLastCommand implements Command {

    private static final Logger LOGGER = LogManager.getLogger(
            SaveLastCommand.class);

    @Override
    public String execute(final String request) {

        String response;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        MatrixService matrixService = serviceFactory.getMatrixService();

        if (request.isEmpty()) {
            return MessageManager.getProperty("message.incorrect.args.number");
        } else {
            try {
                matrixService.saveLastResult(request);
                response = MessageManager.getProperty(
                        "message.save.last.result.correct");
            } catch (ServiceException e) {
                response = e.getMessage();
                LOGGER.error(response);
            }
        }
        return response;
    }
}
