package fourth.model;

import java.util.ArrayList;
import java.util.Random;

public class Grotto {

    private static final int NUMBER_OF_CHESTS = 100;

    private ArrayList<Chest> chests;

    public Grotto() {
        chests = new ArrayList<>();

        Random rand = new Random();
        for (int i = 0; i < NUMBER_OF_CHESTS; i++) {
            chests.add(new Chest(rand));
        }
    }

    public ArrayList<Chest> getChests() {
        return chests;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chests.size(); i++) {
            sb.append("Chest ")
                    .append(i + 1)
                    .append(" - value is ")
                    .append(String.format("%,d", chests.get(i).getValue()))
                    .append(" USD.")
                    .append("\n")
                    .append(chests.get(i))
                    .append("\n");
        }

        return sb.toString();
    }
}
