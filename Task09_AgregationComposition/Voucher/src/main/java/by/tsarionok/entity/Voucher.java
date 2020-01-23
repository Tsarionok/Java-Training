package by.tsarionok.entity;

public abstract class Voucher {
    private TransportType transportType;
    private FoodType foodType;
    private int dayAmount;
    private double price;
    private Guiding guiding;

    public Voucher() {
        this.transportType = null;
        this.foodType = null;
        this.dayAmount = 0;
        this.price = 0.0d;
    }

    public Voucher(TransportType transportType, FoodType foodType, int dayAmount, double price) {
        this.transportType = transportType;
        this.foodType = foodType;
        this.dayAmount = dayAmount;
        this.price = price;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public void setTransportType(TransportType transportType) {
        this.transportType = transportType;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    public int getDayAmount() {
        return dayAmount;
    }

    public void setDayAmount(int dayAmount) {
        this.dayAmount = dayAmount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Guiding getGuiding() {
        return guiding;
    }

    public void setGuiding(Guiding guiding) {
        this.guiding = guiding;
    }
}

