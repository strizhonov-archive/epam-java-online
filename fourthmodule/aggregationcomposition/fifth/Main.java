package aggregationcomposition.fifth;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Tour[] tours = new Tour[] {
                new Tour(TourType.RECREATION, Transport.AIRCRAFT, 15, true),
                new Tour(TourType.CRUISE, Transport.TRAIN, 21, false),
                new Tour(TourType.TREATMENT, Transport.AIRCRAFT, 11, true),
                new Tour(TourType.SHOPPING, Transport.BUS, 2, true)
        };

        TourList tourList = new TourList(tours);

        Tour[] tempTours = tourList.getSortedByDuration();
        System.out.println(Arrays.toString(tempTours));

        tempTours = tourList.getSortedByMeal();
        System.out.println(Arrays.toString(tempTours));

        tempTours = tourList.getSortedByTransport();
        System.out.println(Arrays.toString(tempTours));

        tempTours = tourList.getSortedByType();
        System.out.println(Arrays.toString(tempTours));

        tempTours = tourList.getByMeals(true);
        tempTours = tourList.getByTransport(Transport.AIRCRAFT, tempTours);
        tempTours = tourList.getLonger(12, tempTours);
        tempTours = tourList.getShorter(17, tempTours);

        System.out.println(Arrays.toString(tempTours));
        System.out.println(Arrays.toString(tours));
        System.out.println(Arrays.toString(tourList.getTours()));


    }

}
