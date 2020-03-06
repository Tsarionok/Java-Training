package by.tsarionok.service.factory;

import by.tsarionok.service.MatrixService;
import by.tsarionok.service.impl.MatrixServiceImpl;

public final class ServiceFactory {

    private static final ServiceFactory INSTANCE = new ServiceFactory();

    private final MatrixService matrixService = new MatrixServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return INSTANCE;
    }

    public MatrixService getMatrixService() {
        return matrixService;
    }
}
