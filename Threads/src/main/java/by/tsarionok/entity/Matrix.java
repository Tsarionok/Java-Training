package by.tsarionok.entity;

public final class Matrix {

    private static Matrix instance = null;

    private int[][] arr;

    private int threadNumber;

    private int[] diagValues;

    private Matrix(final int thread, final int[] values, final int[][] ints) {
        threadNumber = thread;
        diagValues = values;
        arr = ints;
    }

    public static synchronized Matrix getInstance(final int thread,
                                                  final int[] values, final int[][] ints) {

        if (instance == null) {
            instance = new Matrix(thread, values, ints);
        }
        return instance;
    }

    /**
     * Gets arr.
     *
     * @return value of arr.
     */
    public int[][] getArr() {
        return arr;
    }

    /**
     * Sets arr.
     *
     * @param arrValue value of arr.
     */
    public void setArr(final int[][] arrValue) {
        arr = arrValue;
    }

    /**
     * Gets threadNumber.
     *
     * @return value of threadNumber.
     */
    public int getThreadNumber() {
        return threadNumber;
    }

    /**
     * Sets threadNumber.
     *
     * @param threadNumberValue value of threadNumber.
     */
    public void setThreadNumber(final int threadNumberValue) {
        threadNumber = threadNumberValue;
    }

    /**
     * Gets diagValue.
     *
     * @return value of diagValue.
     */
    public int[] getDiagValues() {
        return diagValues;
    }

    /**
     * Sets diagValue.
     *
     * @param diag value of diagValue.
     */
    public void setDiagValues(final int[] diag) {
        this.diagValues = diag;
    }
}
