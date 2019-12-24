package simpleclass.fourth;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

/**
 * Testing class
 */
public class TrainUtils {

    public static Train[] sortByNumber(Train[] trains) {

        trains = trains.clone();

        for (int i = 0; i < trains.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < trains.length; j++) {
                if (trains[j].getTrainNumber() < trains[minIndex].getTrainNumber()) {
                    minIndex = j;
                }
            }

            Train buf = trains[i];
            trains[i] = trains[minIndex];
            trains[minIndex] = buf;
        }

        return trains;
    }

    public static Train[] sortByDestination(Train[] trains) {

        trains = trains.clone();

        for (int i = 0; i < trains.length; i++) {

            int minIndex = i;
            for (int j = i + 1; j < trains.length; j++) {
                if (trains[j].getDestination().compareTo(trains[minIndex].getDestination()) < 0
                        || trains[j].getDestination().compareTo(trains[minIndex].getDestination()) == 0
                        && trains[j].getDepartureTime().compareTo(trains[minIndex].getDepartureTime()) < 0) {
                    minIndex = j;
                }
            }

            Train buf = trains[i];
            trains[i] = trains[minIndex];
            trains[minIndex] = buf;
        }

        return trains;
    }

    public static void printTrainInfo(Train[] trains) {

        System.out.println("To get information about the train, enter its number:");

        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextInt()) {
            System.out.println("Try again. Enter train number:");
            sc.next();
        }

        int trNum = sc.nextInt();

        for (Train train : trains) {
            if (trNum == train.getTrainNumber()) {
                System.out.println("Destination: " + train.getDestination());
                System.out.println("Departure simpleclass.fifth.Time: " + train.getDepartureTime());
            }
        }

    }

    public static void main(String[] args) {

        Train[] trains = new Train[5];

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2019);
        cal.set(Calendar.MONTH, 8);
        cal.set(Calendar.DAY_OF_WEEK, 26);
        cal.set(Calendar.HOUR_OF_DAY, 21);
        cal.set(Calendar.MINUTE, 36);
        trains[0] = new Train("Minsk", 199, cal);

        cal.set(Calendar.HOUR_OF_DAY, 6);
        cal.set(Calendar.MINUTE, 11);
        trains[1] = new Train("Vitebsk", 9, cal);

        cal.set(Calendar.HOUR_OF_DAY, 8);
        cal.set(Calendar.MINUTE, 6);
        trains[2] = new Train("Moscow", 777, cal);

        cal.set(Calendar.HOUR_OF_DAY, 11);
        cal.set(Calendar.MINUTE, 11);
        trains[3] = new Train("Sidney", 11, cal);

        cal.set(Calendar.HOUR_OF_DAY, 13);
        cal.set(Calendar.MINUTE, 15);
        trains[4] = new Train("Minsk", 32, cal);

        System.out.println(Arrays.deepToString(sortByNumber(trains)));
        System.out.println(Arrays.deepToString(trains));
        System.out.println(Arrays.deepToString(sortByDestination(trains)));
        printTrainInfo(trains);

    }

}
