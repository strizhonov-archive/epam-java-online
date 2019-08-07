package fifth.view;

import fifth.controller.InputChecker;
import fifth.model.Flower;
import fifth.model.FlowerComposition;
import fifth.model.Wrapping;

import java.util.Scanner;

public class ConsoleView {

    public String askIfMoreFlowersNeed() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Do you need more flowers in your composition? (y/n)");

            String userInput = sc.next();

            if (InputChecker.checkForYesNoInput(userInput)) {
                return userInput;
            } else {
                printWarning("Illegal input.");
            }
        }
    }

    public Flower getFlower() {
        String type = askType();
        String color = askColor("flower");

        return Flower.FlowerBuilder.newInstance()
                .setType(type)
                .setColor(color)
                .build();
    }

    public Wrapping getWrapping() {
        String color = askColor("wrapping");
        boolean isTransparent = askTransparency();

        return new Wrapping(color, isTransparent);
    }

    public void showComposition(FlowerComposition fc) {
        System.out.println("Now your composition consists of " + fc.getFlowerList().size() + " flower(s):");
        System.out.println(fc);
    }

    private String askColor(String item) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Choose " + item + " color:");
            showAvailableColors();
            String userInput = sc.next();

            if (InputChecker.checkColorInput(userInput)) {
                return getStringColor(userInput);
            } else {
                printWarning("Illegal input.");
            }
        }

    }

    private boolean askTransparency() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Do you wish transparent wrapping? (y/n)");
            String userInput = sc.next();

            if (InputChecker.checkForYesNoInput(userInput)) {
                return "y".equals(userInput);
            } else {
                printWarning("Illegal input.");
            }
        }
    }

    private String askType() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Choose type of flower you want to add:");
            showAvailableTypes();
            String userInput = sc.next();

            if (InputChecker.checkTypeInput(userInput)) {
                return getStringType(userInput);
            } else {
                printWarning("Illegal input.");
            }
        }
    }

    private String getStringColor(String str) {
        switch (str) {
            case "1": return "Yellow";
            case "2": return "Red";
            case "3": return "Purple";
            case "4":
            default: return "White";
        }
    }

    private String getStringType(String str) {
        switch (str) {
            case "1": return "Tulip";
            case "2": return "Rose";
            case "3":
            default: return "Chamomile";
        }
    }

    private void printWarning(String warning) {
        System.out.println(warning);
    }

    private void showAvailableColors() {
        System.out.println("1 - Yellow");
        System.out.println("2 - Red");
        System.out.println("3 - Purple");
        System.out.println("4 - White");
    }

    private void showAvailableTypes() {
        System.out.println("1 - Tulip");
        System.out.println("2 - Rose");
        System.out.println("3 - Chamomile");
    }
}
