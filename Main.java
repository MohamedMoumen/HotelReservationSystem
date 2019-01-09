package system;

import java.nio.file.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class Main extends Application{

    private Stage window;
    private Scene scene;

    private static String readFileAsString(String fileName)throws Exception
    {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }

    public static void main(String[] args) throws Exception {

        //File reading to a string then spliting the  data from file int individual lines
        String arr = readFileAsString("G:\\pp.txt");
        String[] data = arr.split("\n");

        //Data fields for standard rooms
        int[][] standardRoomsNumbers = new int[100][100];
        int[][] standardNumberOfBeds = new int [100][100];
        double[][] standardBedPrices = new double[100][100];

        //Data fields for sweet rooms
        int[][] sweetRoomsNumbers = new int[100][100];
        double[][] sweetPrices = new double[100][100];

        //Data fields for conference rooms
        int[][] conferenceRoomsNumbers = new int[100][100];
        int[][] conferenceNumberOfChairs = new int[100][100];
        double[][] conferenceChairPrices = new double[100][100];

        int line= 1;//line in the data[] string array
        int numberOfFloors = Character.getNumericValue(data[0].charAt(9));//Getting the number of floors from the first index in data[] array
        int[] numberOfRooms = new int[numberOfFloors];

        int i  = 0 ,st = 0,sw = 0,co = 0;//Important variables critical for the data to be stored
        int[] standardRoomsPerFloor = new int [numberOfFloors];
        int[] sweetRoomsPerFloor = new int [numberOfFloors];
        int[] conferenceRoomsPerFloor = new int [numberOfFloors];

        while(numberOfFloors != i){
            //First main loop

            int roomsPerFloor = Character.getNumericValue(data[line].charAt(17));//Getting the number of rooms in each individual floor
            numberOfRooms[i] = roomsPerFloor;
            line++;//Current line of operation in the data[] array

            while(roomsPerFloor != 0){
                //Second main loop
                //Data assigning logic

                //In case of Standard Room
                if(data[line].charAt(1) == 't'){
                    String[] spl = data[line].split(", ");

                    int room = Integer.parseInt(spl[1]);
                    int beds = Integer.parseInt(spl[2]);
                    double price = Double.parseDouble(spl[3]);

                    standardRoomsNumbers[i][st] = room;
                    standardNumberOfBeds[i][st] = beds;
                    standardBedPrices[i][st] = price;
                    st++;
                    standardRoomsPerFloor[i]++;
                }

                //In case of Sweet Room
                else if(data[line].charAt(1) == 'w'){
                    String[] spl = data[line].split(", ");

                    int room = Integer.parseInt(spl[1]);
                    double price = Double.parseDouble(spl[2]);

                    sweetRoomsNumbers[i][sw] = room;
                    sweetPrices[i][sw] = price;
                    sw++;
                    sweetRoomsPerFloor[i]++;
                }

                //In case of Conference Room
                else if(data[line].charAt(1) == 'o'){
                    String[] spl = data[line].split(", ");

                    int room = Integer.parseInt(spl[1]);
                    int nSeats = Integer.parseInt(spl[2]);
                    double price = Double.parseDouble(spl[3]);

                    conferenceRoomsNumbers[i][co] = room;
                    conferenceNumberOfChairs[i][co] = nSeats;
                    conferenceChairPrices[i][co] = price;
                    co++;
                    conferenceRoomsPerFloor[i]++;
                }

                line++;//Changing line in data[] array after reading required fields
                roomsPerFloor--;//Loop breaker hence the name rooms per floor
            }

            st = 0;sw = 0;co = 0;//important and must be equal zero in each floor in order to start counting individual rooms based on type
            i++;//Floor number aka first index in data
        }

        Floor[] floors = new Floor[numberOfFloors];
        for(int j = 0; j < numberOfFloors; j++){
            floors[j] = new Floor(j, numberOfRooms[j], standardRoomsPerFloor[j], sweetRoomsPerFloor[j], conferenceRoomsPerFloor[j]);
            floors[j].instantiateStandardRooms(standardRoomsNumbers, standardNumberOfBeds, standardBedPrices);
            floors[j].instantiateSweetRooms(sweetRoomsNumbers, sweetPrices);
            floors[j].instantiateConferenceRooms(conferenceRoomsNumbers, conferenceNumberOfChairs, conferenceChairPrices);
        }
        //System.out.println(floors[0].showAvailableRooms());
        System.out.println(floors[2].showAvailableRooms());
        System.out.println(floors[0].calculateProfit());
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("Hotel reservation system");
        Label label1 = new Label("Welcome to FCI Hotel system.");


        VBox layout = new VBox(15);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(label1);

        scene = new Scene(layout,350,350);
        window.setScene(scene);
        window.show();

    }
}
