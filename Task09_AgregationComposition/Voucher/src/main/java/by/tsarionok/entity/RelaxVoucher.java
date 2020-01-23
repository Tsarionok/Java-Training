package by.tsarionok.entity;

public class RelaxVoucher extends Voucher {
    private RelaxType relaxType;

    public RelaxVoucher() {
        super();
    }

    public RelaxVoucher(TransportType transportType, FoodType foodType, int dayAmount, RelaxType relaxType, double price) {
        super(transportType, foodType, dayAmount, price);

        this.relaxType = relaxType;
    }

    public RelaxType getRelaxType() {
        return relaxType;
    }

    public void setRelaxType(RelaxType relaxType) {
        this.relaxType = relaxType;
    }

    @Override
    public String toString() {
        return getTransportType() + " " + getFoodType() + " " + getDayAmount() + " " + getRelaxType();
    }
}
