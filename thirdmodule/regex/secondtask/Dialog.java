package regex.secondtask;

import java.util.Scanner;

public class Dialog {


    public boolean askUserToContinue() {

        Scanner sc = new Scanner(System.in);

        String input = "";
        while (!("y".equals(input) || "n".equals(input))) {
            System.out.println("Do you want to get next XML element? y/n");

            while (!sc.hasNext()) {
                System.out.println("Illegal input.");
                sc.next();
            }

            input = sc.next();

            if (!("y".equals(input) || "n".equals(input))) {
                System.out.println("Illegal input.");
            }

        }

        if ("y".equals(input)) {
            return true;
        }

        if ("n".equals(input)) {
            return false;
        }

        return false;
    }
}
