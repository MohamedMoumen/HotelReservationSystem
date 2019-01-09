package system;

public abstract class Room {
    private int roomNumber;
    private int daysOfReservation;
    private boolean isReserved;

    public Room() {
        this(0,0,false);
    }

    public Room(int roomNumber, int daysOfReservation, boolean isReserved) {
        this.roomNumber = roomNumber;
        this.daysOfReservation = daysOfReservation;
        this.isReserved = isReserved;
    }

    public void reserveRoom(int roomNumber, int daysOfReservation){
        //Exception to be added here
        if(this.isReserved != true){
            this.setDaysOfReservation(daysOfReservation);
            this.setRoomNumber(roomNumber);
            this.setReserved(true);
        }else{
            System.out.println("room already reserved ");
        }

    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getDaysOfReservation() {
        return daysOfReservation;
    }

    public void setDaysOfReservation(int daysOfReservation) {
        this.daysOfReservation = daysOfReservation;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    public abstract double getTotalPrice();

    public abstract String toString();
}
