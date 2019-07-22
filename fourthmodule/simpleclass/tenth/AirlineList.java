package simpleclass.tenth;

import java.time.DayOfWeek;
import java.util.Calendar;

public class AirlineList {

    private Airline[] airlines;

    public AirlineList(Airline[] airlines) {
        this.airlines = airlines;
    }

    public Airline[] getAirlines() {
        return airlines;
    }

    public void printAirlinesTo(String destination) {
        System.out.println("Airlines to " + destination + ":");

        for (Airline airline : airlines) {
            if (destination.equals(airline.getDestination())) {
                System.out.println(airline);
            }
        }
    }

    public void printAirlinesOn(DayOfWeek dayOfWeek) {
        System.out.println("Airlines on " + dayOfWeek + ":");

        for (Airline airline : airlines) {
            for (DayOfWeek day : airline.getDepartureDays()) {
                if (dayOfWeek.equals(day)) {
                    System.out.println(airline);
                }
            }
        }
    }

    public void printAirlinesOn(DayOfWeek dayOfWeek, Calendar departureAfter) {
        System.out.println("Airlines on " + dayOfWeek + " after "
                + departureAfter.get(Calendar.HOUR_OF_DAY) + ":"
                + departureAfter.get(Calendar.MINUTE)
                + ":");

        for (Airline airline : airlines) {
            if (airline.getDepartureTime().compareTo(departureAfter) > 0) {
                for (DayOfWeek day : airline.getDepartureDays()) {
                    if (dayOfWeek.equals(day)) {
                        System.out.println(airline);
                    }
                }
            }
        }

    }
}
