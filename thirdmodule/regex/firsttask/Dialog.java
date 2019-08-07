package regex.firsttask;

import java.util.Scanner;

public class Dialog {

    public void printText(String text) {
        System.out.println(text);
    }


    public int getOperationFromUser() {

        System.out.println("Enter \"1\" to sort paragraphs by sentences quantity;");
        System.out.println("\"2\" to sort words in sentences by its length;");
        System.out.println("\"3\" to sort the tokens in the sentence in descending order " +
                "(by the occurrences of a character), or by the alphabet in case of equality;");
        System.out.println("\"4\" to quit.");

        Scanner sc = new Scanner(System.in);

        while (!sc.hasNextInt()) {
            System.out.println("Illegal input.");
            sc.next();
        }

        return sc.nextInt();

    }

    public char getSymbolFromUser() {

        Scanner sc = new Scanner(System.in);

        String sChar = "";
        while (sChar.length() != 1) {
            System.out.println("Enter character to order sorting:");

            sChar = sc.next();

            if (sChar.length() != 1) {
                System.out.println("Illegal input.");
            }

        }

        return sChar.charAt(0);
    }

}
