package cycleprogram;

import java.util.Scanner;

public class Seventh {

    public static void askIntervalAndPrintDenominators() {

        Scanner sc = new Scanner(System.in);

        // Getting start value of an interval
        System.out.println("Enter start interval value:");

        while (!sc.hasNextInt()) {
            System.out.println("Entered value is invalid.");
            System.out.println("Please, enter start value:");
            sc.next();
        }

        int startValue = sc.nextInt();


        // Getting end value of the interval
        System.out.println("Enter end interval value:");

        while (!sc.hasNextDouble()) {
            System.out.println("Entered value is invalid.");
            System.out.println("Please, enter end interval value:");
            sc.next();
        }

        int endValue = sc.nextInt();

        sc.close();


        // Finding start interval number (checking for non-positive entered value, which is legit according to task)
        startValue = Math.max(startValue, 1);

        // Finding and printing denominators
        for (int i = startValue; i <= endValue; i++) {

            System.out.print(i + ":");

            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    System.out.print(" " + j);
                }
            }
            System.out.println();
        }

    }

}
