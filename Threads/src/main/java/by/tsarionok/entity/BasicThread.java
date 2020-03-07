package by.tsarionok.entity;

public abstract class BasicThread {

    private int id;

    private String name;

    private int[][] array;

    private int[] values;

    public BasicThread(final int idValue, final String nameValue,
                       final int[][] arrayValue, final int[] diagValues) {
        id = idValue;
        name = nameValue + " #" + idValue;
        array = arrayValue;
        values = diagValues;
    }

    protected int getId() {
        return id;
    }

    public void setId(final int idValue) {
        id = idValue;
    }

    protected String getName() {
        return name;
    }

    public void setName(final String nameValue) {
        name = nameValue;
    }

    public int[][] getArray() {
        return array;
    }

    public void setArray(final int[][] arrayValue) {
        array = arrayValue;
    }

    public int[] getValues() {
        return values;
    }

    public void setValues(final int[] diagValues) {
        values = diagValues;
    }
}
