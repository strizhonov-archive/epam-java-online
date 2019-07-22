package simpleclass.fourth;

import java.util.Calendar;
import java.util.Date;

public class Train {

    private String destination;
    private int trainNumber;
    private Date departureTime;

    public Train(String destination, int trainNumber, Calendar departureTime) {
        this.destination = destination;
        this.trainNumber = trainNumber;
        this.departureTime = departureTime.getTime();
    }

    public String getDestination() {
        return destination;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    @Override
    public String toString() {
        return "Train{" +
                "destination='" + destination + '\'' +
                ", trainNumber=" + trainNumber +
                ", departureTime=" + departureTime +
                '}' + "\n";
    }
}
