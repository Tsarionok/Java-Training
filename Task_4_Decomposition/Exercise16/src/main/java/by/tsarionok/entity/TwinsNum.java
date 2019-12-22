package by.tsarionok.entity;

import java.util.Objects;

public class TwinsNum {
    private Integer firstNumber;
    private Integer secondNumber;

    public TwinsNum(Integer firstNumber, Integer secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public Integer getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(Integer firstNumber) {
        this.firstNumber = firstNumber;
    }

    public Integer getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(Integer secondNumber) {
        this.secondNumber = secondNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TwinsNum twinsNum = (TwinsNum) o;
        return Objects.equals(firstNumber, twinsNum.firstNumber) &&
                Objects.equals(secondNumber, twinsNum.secondNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstNumber, secondNumber);
    }

    @Override
    public String toString() {
        return firstNumber + " and " + secondNumber;
    }
}
