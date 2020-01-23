package by.tsarionok.entity;

public class TherapeuticVoucher extends Voucher {
    private TherapeuticType therapeuticType;

    public TherapeuticVoucher() {
        super();
    }

    public TherapeuticVoucher(TransportType transportType, FoodType foodType,
                              int dayAmount, TherapeuticType therapeuticType, double price) {
        super(transportType, foodType, dayAmount, price);

        this.therapeuticType = therapeuticType;
    }

    public TherapeuticType getTherapeuticType() {
        return therapeuticType;
    }

    public void setTherapeuticType(TherapeuticType therapeuticType) {
        this.therapeuticType = therapeuticType;
    }

    @Override
    public String toString() {
        return getTransportType() + " " + getFoodType() + " " + getDayAmount() + " " + getTherapeuticType();
    }
}
