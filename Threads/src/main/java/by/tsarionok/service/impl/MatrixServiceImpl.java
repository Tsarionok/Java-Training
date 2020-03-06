package by.tsarionok.service.impl;

import by.tsarionok.repository.Repository;
import by.tsarionok.repository.exception.RepositoryException;
import by.tsarionok.repository.factory.RepositoryFactory;
import by.tsarionok.repository.specification.fill.FillByExecutorSpecification;
import by.tsarionok.repository.specification.fill.FillByLockSpecification;
import by.tsarionok.repository.specification.fill.FillBySemaphoreSpecification;
import by.tsarionok.repository.specification.fill.FillBySeparateThreadsSpecification;
import by.tsarionok.service.MatrixService;
import by.tsarionok.service.exception.ServiceException;
import by.tsarionok.service.validator.Validator;

public class MatrixServiceImpl implements MatrixService {

    private Repository matrixRepository;

    private Validator validator;

    public MatrixServiceImpl() {
        RepositoryFactory factory = RepositoryFactory.getInstance();
        matrixRepository = factory.getMatrixRepository();
        validator = new Validator();
    }

    @Override
    public void createMatrix(final String path, final String delimiter) throws
            ServiceException {
        try {
            if (!validator.isValidValue(path)) {
                throw new ServiceException("The parameters for creating matrix"
                        + " are not valid");
            } else {
                matrixRepository.createMatrix(path, delimiter);
            }
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public int[][] fillBySeparateThreads() throws ServiceException {
        try {
            return matrixRepository
                    .query(new FillBySeparateThreadsSpecification());
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public int[][] fillByLocks() throws ServiceException {
        try {
            return matrixRepository
                    .query(new FillByLockSpecification());
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public int[][] fillByExecutorService() throws ServiceException {
        try {
            return matrixRepository.query(new FillByExecutorSpecification());
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public int[][] fillBySemaphore() throws ServiceException {
        try {
            return matrixRepository
                    .query(new FillBySemaphoreSpecification());
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void saveLastResult(final String path) throws ServiceException {
        try {
            if (!validator.isValidValue(path)) {
                throw new ServiceException("The parameters for saving  are "
                        + "not valid");
            } else {
                matrixRepository.saveLastResult(path);
            }
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }


}
