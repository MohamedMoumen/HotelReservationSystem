package system;

public class ConferenceRoom extends Room {
    private int numberOfSeats;
    private double seatPrice;

    public ConferenceRoom() {
        super();
        this.numberOfSeats = 0;
        this.seatPrice = 0.0;
    }

    public ConferenceRoom(int numberOfSeats, double seatPrice) {
        super();
        this.numberOfSeats = numberOfSeats;
        this.seatPrice = seatPrice;
    }

    public ConferenceRoom(int roomNumber, int daysOfReservation, boolean isReserved, int numberOfSeats, double seatPrice) {
        super(roomNumber, daysOfReservation, isReserved);
        this.numberOfSeats = numberOfSeats;
        this.seatPrice = seatPrice;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public double getSeatPrice() {
        return seatPrice;
    }

    public void setSeatPrice(double seatPrice) {
        this.seatPrice = seatPrice;
    }

    @Override
    public double getTotalPrice() {
        return this.numberOfSeats * this.seatPrice * super.getDaysOfReservation();
    }

    @Override
    public String toString() {
        return "Number of seats in this room is " + this.numberOfSeats + ", price per seat is " + this.seatPrice + " and the total price is " + this.getTotalPrice();
    }
}
