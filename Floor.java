package system;

public class Floor {

    private int floorNumber;
    private int numberOfRooms;
    private int numberOfStandardRooms;
    private int numberOfSweetRooms;
    private int numberOfConferenceRooms;

    //Constructor
    public Floor(int floorNumber, int numberOfRooms, int numberOfStandardRooms, int numberOfSweetRooms, int numberOfConferenceRooms) {
        this.floorNumber = floorNumber;
        this.numberOfRooms = numberOfRooms;
        this.numberOfStandardRooms = numberOfStandardRooms;
        this.numberOfSweetRooms = numberOfSweetRooms;
        this.numberOfConferenceRooms = numberOfConferenceRooms;
    }

    //Instance of Room (array contains list of rooms) assigned during runtime
    private Room[] standardRooms = new StandardRoom [100];
    private Room[] sweetRooms = new SweetRoom[100];
    private Room[] conferenceRooms = new ConferenceRoom[100];

    //Getters
    public int getFloorNumber() { return floorNumber + 1; }

    public int getNumberOfRooms() { return numberOfRooms; }

    public int getNumberOfStandardRooms() { return numberOfStandardRooms;}

    public int getNumberOfSweetRooms() { return numberOfSweetRooms; }

    public int getNumberOfConferenceRooms() { return numberOfConferenceRooms; }

    //Configuration handling
    //These functions will only work once hence the hard data handling
    //no need for number of floor because this is a part of an array ,the number of floor is this object
    public void instantiateStandardRooms(int[][] roomNumber, int[][] numberOfBeds,double[][] bedPrice){
        for(int i = 0;i < this.numberOfStandardRooms;i++){
            this.standardRooms[i] = new StandardRoom(roomNumber[this.floorNumber][i],0, false,numberOfBeds[this.floorNumber][i], bedPrice[this.floorNumber][i]);
        }
    }

    public void instantiateSweetRooms(int[][] roomNumber,double[][] price){
        for(int i = 0;i < this.numberOfSweetRooms;i++){
            this.sweetRooms[i]= new SweetRoom(roomNumber[this.floorNumber][i],0,false,price[this.floorNumber][i]);
        }
    }

    public void instantiateConferenceRooms(int[][] roomNumber, int[][] numberOfSeats,double[][] seatPrice){
        for(int i = 0;i < numberOfConferenceRooms;i++){
            this.conferenceRooms[i] = new ConferenceRoom(roomNumber[this.floorNumber][i],0, false, numberOfSeats[this.floorNumber][i], seatPrice[this.floorNumber][i]);
        }
    }

    //Displays available rooms based on isReserved method
    public int showAvailableRooms(){
        int totalRoomsEmpty = 0;

        for(int i = 0;i < this.numberOfStandardRooms;i++){

            if(!this.standardRooms[i].isReserved()){
                totalRoomsEmpty++;
            }
        }

        for(int i = 0;i < this.numberOfSweetRooms;i++){
            if(!this.sweetRooms[i].isReserved()){
                totalRoomsEmpty++;
            }
        }

        for(int i = 0;i < this.numberOfConferenceRooms;i++){
            if(!this.conferenceRooms[i].isReserved()){
                totalRoomsEmpty++;
            }
        }
        return totalRoomsEmpty;
    }

    //Calculates profit based on getTotalPrice method
    //Shows total profit in all rooms Based on check is reserved and get total price of Room instance
    public double calculateProfit(){
        double totalProfit = 0;
        for(int i = 0;i < this.numberOfStandardRooms;i++){
            if(this.standardRooms[i].isReserved()){
                totalProfit += this.standardRooms[i].getTotalPrice();
            }
        }

        for(int i = 0;i < this.numberOfSweetRooms;i++){
            if(this.sweetRooms[i].isReserved()){
                totalProfit += this.sweetRooms[i].getTotalPrice();
            }
        }

        for(int i = 0;i < this.numberOfConferenceRooms;i++){
            if(this.conferenceRooms[i].isReserved()){
                totalProfit += this.conferenceRooms[i].getTotalPrice();
            }
        }
        return totalProfit;
    }

    //Making reservations
    //Throws exception
    public void makeReservation (int roomNumber, int roomType, int daysOfReservation){
        try {
            if(roomType == 1){
                this.standardRooms[roomNumber].setReserved(true);
                this.standardRooms[roomNumber].setDaysOfReservation(daysOfReservation);
            }
            else if(roomType == 2){
                this.sweetRooms[roomNumber].setReserved(true);
                this.sweetRooms[roomNumber].setDaysOfReservation(daysOfReservation);
            }
            else if(roomType == 3){
                this.conferenceRooms[roomNumber].setReserved(true);
                this.conferenceRooms[roomNumber].setDaysOfReservation(daysOfReservation);
            }else throw new IllegalArgumentException("Can't reserve a room type that does't exist.");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
