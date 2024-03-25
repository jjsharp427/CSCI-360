import java.util.*;

public class Airport {

    public ArrayList<Aircraft> planes;
    public String ICAO;
    public String name;
    public double latitude;
    public double longitude;
    public double frequency;
    public String fuelSupport;
    public String fuel;


    public Airport(String ICAO, String name, double longitude, double frequency, double latitude, String fuelSupport, String fuel) {
        this.ICAO = ICAO;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.frequency = frequency;
        this.fuelSupport = fuelSupport;
        this.fuel = fuel;
    }



}
