package fourth.view;

import fourth.model.Chest;
import fourth.model.Grotto;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleView {

    private long money;
    private Grotto grotto;
    private ArrayList<Chest> picked;

    public ConsoleView(long startMoney) {
        money = startMoney;
        grotto = new Grotto();
        picked = new ArrayList<>();
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public Grotto getGrotto() {
        return grotto;
    }

    public void setGrotto(Grotto grotto) {
        this.grotto = grotto;
    }

    public ArrayList<Chest> getPicked() {
        return picked;
    }

    public void setPicked(ArrayList<Chest> picked) {
        this.picked = picked;
    }

    public void printWarning(String message) {
        System.out.println(message);
    }

    public void printExitMessage(String message) {
        System.out.println(message);
    }

    public void showChestPickingDialog() {
        showMoney();
        int userInput = -1;

        while (userInput != 0) {

            if (countAvailable() > 0) {

                System.out.println("You can choose one of the next chests:");
                showAvailable();

                userInput = getChestFromUser();
                int chestNumber;
                if (userInput != 0) {
                    chestNumber = userInput - 1;

                    if (money > grotto.getChests().get(chestNumber).getValue()) {
                        picked.add(grotto.getChests().get(chestNumber));
                        money -= grotto.getChests().get(chestNumber).getValue();
                        grotto.getChests().remove(chestNumber);
                        showMoney();
                    } else {
                        printNoMoney();
                    }

                }

            } else {
                printNoMoney();
                break;
            }

        }

        if (picked.size() > 0) {
            System.out.println("Now you have next chests:");

            int counter = 0;
            for (Chest chest : picked) {
                System.out.println(++counter + " chest:\n" + chest);
            }
        }

    }

    public void showGrotto() {
        System.out.println(grotto);
    }

    public void showMenu() {
        System.out.println("You are in the grotto. Why are you here?");
        System.out.println("1 - I'd like to see what treasures are there.");
        System.out.println("2 - I'd like look at the most valuable chest in here.");
        System.out.println("3 - I have some money. What chests could I got for it?");
        System.out.println("4 - I want to check what I have got now.");
        System.out.println("5 - Load my money and chests.");
        System.out.println("6 - Save my money and chests and get out of here.");
        System.out.println("7 - I want to get out of here without saving.");
    }

    public void showMostValuableChest() {
        ArrayList<Chest> cList = grotto.getChests();

        int index = getMostValuableChestIndex();

        System.out.println("Chest #" + (index + 1) + " is the most valuable. Its worth is "
                + String.format("%,d", cList.get(index).getValue())
                + " USD. Chest contains\n" + cList.get(index));
    }

    public void showUserProperty() {
        System.out.println("Your money: " + String.format("%,d", money) + " USD.\n");

        int counter = 0;
        for (Chest chest : picked) {
            System.out.println("Chest #" + ++counter + ":\n" + chest);
        }
    }

    private int countAvailable() {
        ArrayList<Chest> cList = grotto.getChests();

        int counter = 0;

        for (Chest chest : cList) {
            if (money > chest.getValue()) {
                counter++;
            }
        }
        return counter;
    }

    private int getChestFromUser() {
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("What chest would you pick? (\"0\" to return)");

            while (!sc.hasNextInt()) {
                sc.next();
            }

            int userChoice = sc.nextInt();

            if (userChoice < 0 || userChoice > grotto.getChests().size()) {
                System.out.println("Illegal input.");
            } else {
                return userChoice;
            }
        }
    }

    private int getMostValuableChestIndex() {
        ArrayList<Chest> cList = grotto.getChests();

        int maxIndex = 0;
        Chest max = cList.get(maxIndex);

        for (int i = 0; i < cList.size(); i++) {
            if (cList.get(i).getValue() > max.getValue()) {
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    private void printNoMoney() {
        System.out.println("Not enough money!");
    }

    private void showAvailable() {
        ArrayList<Chest> cList = grotto.getChests();

        for (int i = 0; i < cList.size(); i++) {
            if (money > cList.get(i).getValue()) {
                System.out.println("Chest #" + (i + 1) + " ("
                        + String.format("%,d", cList.get(i).getValue()) + " USD):\n" + cList.get(i));
            }
        }
    }

    private void showMoney() {
        System.out.println("You have " + String.format("%,d", money) + " USD now.");
    }


}
