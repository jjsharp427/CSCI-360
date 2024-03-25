import java.util.*;
import java.io.*;

public class Main {
    public static ArrayList<Airport> listMaker(){
        ArrayList<Airport> airportList = new ArrayList<>();

        try {
            Scanner input = new Scanner(new File("Airport.dat"));
            while(input.hasNext()) {
                String line = input.nextLine(); // use tempString to hold the line
                String[] tokens = line.split(",");
                Airport a1 = new Airport(tokens[0],tokens[1],Double.parseDouble(tokens[2]),Double.parseDouble(tokens[3]),Double.parseDouble(tokens[4]),tokens[5],tokens[6]);
                airportList.add(a1);
            }
            input.close();
        } catch (IOException exc) {
            // TODO: handle exception
            System.out.println(exc.getMessage());
        }
        return airportList;
    

    }
    public static ArrayList<Aircraft> listMaker2() {
        ArrayList<Aircraft> aircraftList = new ArrayList<>();
        try {
            

            Scanner input2 = new Scanner(new File("Aircraft.dat"));
        
            while (input2.hasNext()) {
                String line = input2.nextLine();
                String[] tokens = line.split(", ");
                Aircraft a1 = new Aircraft(tokens[0], tokens[1], tokens[2], Integer.parseInt(tokens[3]), Double.parseDouble(tokens[4]), Integer.parseInt(tokens[5]));
                aircraftList.add(a1);
            }
            
            input2.close();
            
        } catch (IOException exc) {
            // TODO: handle exception
            System.out.println(exc.getMessage());
        }
        return aircraftList;
    }

}
