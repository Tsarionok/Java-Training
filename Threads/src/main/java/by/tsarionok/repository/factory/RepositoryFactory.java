package by.tsarionok.repository.factory;

import by.tsarionok.repository.Repository;
import by.tsarionok.repository.impl.MatrixRepository;

public final class RepositoryFactory {

    private static final RepositoryFactory INSTANCE = new RepositoryFactory();

    private final Repository matrixRepository = new MatrixRepository();

    private RepositoryFactory() {
    }

    public static RepositoryFactory getInstance() {
        return INSTANCE;
    }

    public Repository getMatrixRepository() {
        return matrixRepository;
    }
}
