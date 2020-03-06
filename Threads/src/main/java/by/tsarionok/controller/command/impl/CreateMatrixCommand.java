package by.tsarionok.controller.command.impl;

import by.tsarionok.controller.command.Command;
import by.tsarionok.controller.command.manager.MessageManager;
import by.tsarionok.service.MatrixService;
import by.tsarionok.service.exception.ServiceException;
import by.tsarionok.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CreateMatrixCommand implements Command {

    private static final Logger LOGGER = LogManager.getLogger(
            CreateMatrixCommand.class);

    private static final String DEL = " ";

    private static final int LIMIT = 2;

    @Override
    public String execute(final String request) {

        String response;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        MatrixService matrixService = serviceFactory.getMatrixService();

        String[] args = request.split(DEL, LIMIT);

        if (args.length != LIMIT) {
            return MessageManager.getProperty("message.incorrect.args.number");
        } else {
            try {
                matrixService.createMatrix(args[0], args[1]);
                response = MessageManager.getProperty(
                        "message.matrix.create.correct");
            } catch (ServiceException e) {
                response = e.getMessage();
                LOGGER.error(response);
            }
        }
        return response;
    }
}
