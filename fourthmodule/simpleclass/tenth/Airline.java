package simpleclass.tenth;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.Calendar;

public class Airline {
    private String destination;
    private int flightNumber;
    private String aircraftType;
    private Calendar departureTime;
    private DayOfWeek[] departureDays;

    public Airline(String destination, int flightNumber, String aircraftType,
                   Calendar departureTime, DayOfWeek[] departureDays) {
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.aircraftType = aircraftType;
        this.departureTime = departureTime;
        this.departureDays = departureDays;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(String aircraftType) {
        this.aircraftType = aircraftType;
    }

    public Calendar getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Calendar departureTime) {
        this.departureTime = departureTime;
    }

    public DayOfWeek[] getDepartureDays() {
        return departureDays;
    }

    public void setDepartureDays(DayOfWeek[] departureDays) {
        this.departureDays = departureDays;
    }

    @Override
    public String toString() {
        return "Airline:" +
                "destination='" + destination + '\'' +
                ", flightNumber=" + flightNumber +
                ", aircraftType='" + aircraftType + '\'' +
                ", departureTime=" + departureTime +
                ", departureDays=" + Arrays.toString(departureDays);
    }
}
