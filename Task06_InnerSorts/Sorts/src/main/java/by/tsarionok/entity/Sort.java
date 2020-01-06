package by.tsarionok.entity;

public enum Sort {
    BUBBLE_SORT(1),
    INSERTION_SORT(1);

    int pos;

    Sort(int pos) {
        this.pos = pos;
    }

    public int getPos() {
        return pos;
    }
}
