package cycleprogram;

import java.util.Scanner;

public class First {

    public static void askNumberAndPrintSum() {

        Scanner sc = new Scanner(System.in);

        int userInteger = 0;
        while (userInteger <= 0) {

            System.out.println("Enter single positive integer value:");

            if (!sc.hasNextInt()) {
                sc.next();
            } else {
                userInteger = sc.nextInt();
            }
        }

        sc.close();

        int sum = 0;
        for (int i = 1; i <= userInteger; i++) {
            sum += i;
        }

        System.out.println(sum);
    }
}
