package system;

public class SweetRoom extends Room {
    private double pricePerNight;

    public SweetRoom() {
        super();
        this.pricePerNight = 0.0;
    }

    public SweetRoom(double pricePerNight) {
        super();
        this.pricePerNight = pricePerNight;
    }

    public SweetRoom(int roomNumber, int daysOfReservation, boolean isReserved, double pricePerNight) {
        super(roomNumber, daysOfReservation, isReserved);
        this.pricePerNight = pricePerNight;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    @Override
    public double getTotalPrice() {
        return this.pricePerNight * super.getDaysOfReservation();

    }

    @Override
    public String toString() {
        return "Price per night in this room is " + this.pricePerNight + " and the total price is " + this.getTotalPrice();
    }
}
