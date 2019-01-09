package system;

public class StandardRoom extends Room {
    private int numberOfBeds;
    private double bedPrice;

    public StandardRoom() {
        super();
        this.numberOfBeds = 0;
        this.bedPrice = 0.0;
    }

    public StandardRoom(int numberOfBeds, double bedPrice) {
        super();
        this.numberOfBeds = numberOfBeds;
        this.bedPrice = bedPrice;
    }

    public StandardRoom(int roomNumber, int daysOfReservation, boolean isReserved, int numberOfBeds, double bedPrice) {
        super(roomNumber, daysOfReservation, isReserved);
        this.numberOfBeds = numberOfBeds;
        this.bedPrice = bedPrice;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public double getBedPrice() {
        return bedPrice;
    }

    public void setBedPrice(double bedPrice) {
        this.bedPrice = bedPrice;
    }

    @Override
    public double getTotalPrice() {
        return this.numberOfBeds * this.bedPrice * super.getDaysOfReservation();
    }

    @Override
    public String toString() {
        return "Number of beds is " + this.numberOfBeds + ", price per bed in this room is " + this.bedPrice + " and total price is " + this.getTotalPrice();
    }
}
