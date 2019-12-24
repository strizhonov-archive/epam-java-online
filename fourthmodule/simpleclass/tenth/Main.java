package simpleclass.tenth;

import java.time.DayOfWeek;
import java.util.Calendar;

/**
 * Testing class
 */
public class Main {

    public static void main(String[] args) {

        Calendar cal1 = Calendar.getInstance();
        cal1.set(Calendar.HOUR_OF_DAY, 13);
        cal1.set(Calendar.MINUTE, 0);

        Calendar cal2 = Calendar.getInstance();
        cal2.set(Calendar.HOUR_OF_DAY, 1);
        cal2.set(Calendar.MINUTE, 14);

        Calendar cal3 = Calendar.getInstance();
        cal3.set(Calendar.HOUR_OF_DAY, 23);
        cal3.set(Calendar.MINUTE, 11);

        Calendar cal4 = Calendar.getInstance();
        cal4.set(Calendar.HOUR_OF_DAY, 11);
        cal4.set(Calendar.MINUTE, 50);

        Airline[] airlines = new Airline[]{
                new Airline("Minsk", 532, "TU-154",
                        cal1, new DayOfWeek[]{DayOfWeek.MONDAY, DayOfWeek.SATURDAY}),
                new Airline("Moscow", 111, "BOEING 474",
                        cal2, new DayOfWeek[]{DayOfWeek.SATURDAY}),
                new Airline("Minsk", 14, "TU-134",
                        cal3, new DayOfWeek[]{DayOfWeek.MONDAY, DayOfWeek.THURSDAY, DayOfWeek.SATURDAY}),
                new Airline("SPB", 4367, "AIRBUS 17",
                        cal4, new DayOfWeek[]{DayOfWeek.MONDAY}),
        };

        AirlineList aList = new AirlineList(airlines);

        aList.printAirlinesTo("Minsk");
        aList.printAirlinesOn(DayOfWeek.MONDAY);

        cal1.set(Calendar.HOUR_OF_DAY, 12);
        cal1.set(Calendar.MINUTE, 15);
        aList.printAirlinesOn(DayOfWeek.SATURDAY, cal1);

    }

}
