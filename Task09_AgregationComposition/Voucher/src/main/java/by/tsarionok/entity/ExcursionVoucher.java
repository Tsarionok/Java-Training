package by.tsarionok.entity;

public class ExcursionVoucher extends Voucher {
    private ExcursionType excursionType;

    public ExcursionVoucher() {
        super();
    }

    public ExcursionVoucher(TransportType transportType, FoodType foodType,
                            int dayAmount, ExcursionType excursionType, double price) {
        super(transportType, foodType, dayAmount, price);

        this.excursionType = excursionType;
    }

    public ExcursionType getExcursionType() {
        return excursionType;
    }

    public void setExcursionType(ExcursionType excursionType) {
        this.excursionType = excursionType;
    }

    @Override
    public String toString() {
        return getTransportType() + " " + getFoodType() + " " + getDayAmount() + " " + getExcursionType();
    }
}
