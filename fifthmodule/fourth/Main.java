package fourth;

import fourth.controller.SaverLoader;
import fourth.view.ConsoleView;

import java.util.Scanner;

/**
 * Testing class
 */
public class Main {

    private static final long START_MONEY = 1_000_000L;

    public static void main(String[] args) {

        ConsoleView cv = new ConsoleView(START_MONEY);

        Scanner sc = new Scanner(System.in);
        int userChoice = -1;

        while (userChoice != 6 && userChoice != 7) {

            cv.showMenu();

            while (!sc.hasNextInt()) {
                cv.printWarning("Illegal input.");
                cv.showMenu();

                sc.next();
            }

            userChoice = sc.nextInt();

            switch (userChoice) {
                case 1:
                    cv.showGrotto();
                    break;
                case 2:
                    cv.showMostValuableChest();
                    break;
                case 3:
                    cv.showChestPickingDialog();
                    break;
                case 4:
                    cv.showUserProperty();
                    break;
                case 5:
                    cv = SaverLoader.load();
                    break;
                case 6:
                    SaverLoader.save(cv);
                    cv.printExitMessage("Bye!");
                    break;
                case 7:
                    cv.printExitMessage("Bye!");
                default:
                    break;
            }
        }

    }

    public static long getStartMoney() {
        return START_MONEY;
    }

}
