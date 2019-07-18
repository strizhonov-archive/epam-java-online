package regex.firsttask;

public class Main {

    private static final String TEXT = "Однажды на какой-то станции я видел, как все проводницы ушли в буфет и заболтались, " +
            "а поезд вдруг медленно поплыл вдоль перрона. Тётки вылетели на платформу и, проклиная машиниста-хохмача, который " +
            "не дал гудок, толпой кинулись вдогонку, а из дверей последнего вагона начальник поезда бессовестно свистел в два " +
            "пальца, как болельщик на стадионе. Конечно, шутка грубая, но никто не обиделся, и хохотали потом все вместе.\n " +
            "Здесь проводить своих чад к поезду подруливали на мотоциклах с колясками растерянные родители, целовались и горько " +
            "веселились, играли на гармошках и, бывало, плясали. Здесь проводницы велели пассажирам самим высчитать, сколько " +
            "стоит билет, и принести им без сдачи, и пассажиры честно рылись в кошельках и кошёлках, отыскивая мелочь. " +
            "Здесь каждый был причастен к общему движению и переживал его по-своему. Можно было выйти в тамбур, открыть " +
            "дверь наружу, сесть на железные ступеньки и просто смотреть на мир, и никто тебя не отругает.\n" +
            "Чусовская — Тагил, поезд моего детства.";

    public static void main(String[] args) {

        Dialog dialog = new Dialog();

        dialog.printText(TEXT);

        int userChoice = dialog.getOperationFromUser();

        while (userChoice != 4) {
            if (userChoice == 3) {
                operate(dialog);
            } else {
                operate(userChoice);
            }

            userChoice = dialog.getOperationFromUser();
        }

    }

    private static void operate(int userChoice) {

        switch (userChoice) {
            case 1:
                System.out.println(Utils.sortParagraphs(TEXT));
                break;
            case 2:
                System.out.println(Utils.sortWordsByLength(TEXT));
                break;
            default:
                break;
        }
    }

    private static void operate(Dialog dialog) {
        char c = dialog.getSymbolFromUser();
        System.out.println(Utils.sortLexemes(TEXT, c));
    }


}
