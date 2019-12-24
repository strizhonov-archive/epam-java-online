package linear;

/**
 * Дано натуральное число Т, которое представляет длительность прошедшего времени в секундах. Вывести
 * данное значение длительности в часах, минутах и секундах в следующей форме:
 * ННч ММмин SSc.
 */

public class Fifth {

    public static void secondsToFullTime(int seconds) {

        int hours = 0;
        int minutes = 0;

        if (seconds >= 60) {
            minutes = seconds / 60;
            seconds = seconds % 60;

            if (minutes >= 60) {
                hours = minutes / 60;
                minutes = minutes % 60;
            }
        }

        String sHours = hours + "ч";
        String sMinutes = minutes + "мин";
        String sSeconds = seconds + "с";

        if (hours < 10) {
            sHours = "0" + sHours;
        }
        if (minutes < 10) {
            sMinutes = "0" + sMinutes;
        }
        if (seconds < 10) {
            sSeconds = "0" + sSeconds;
        }

        System.out.println(sHours + " " + sMinutes + " " + sSeconds);
    }

}
