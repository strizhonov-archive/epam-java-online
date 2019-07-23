package fourth.model;

import java.util.ArrayList;
import java.util.Random;

public class Chest {

    private static final int CHEST_CAPACITY = 1000;

    private long value;
    private ArrayList<Treasure> treasures;

    public Chest() {
        treasures = new ArrayList<>();
    }

    public Chest(Random rand) {

        int n = rand.nextInt(TreasureType.values().length) + 1;

        treasures = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            TreasureType randTreasure = TreasureType.getRandom();
            boolean isThereDuplicate = false;

            for (Treasure treasure : treasures) {

                if (treasure != null && randTreasure.name().equals(treasure.getTreasureType().name())) {
                    isThereDuplicate = true;
                    i--;
                    break;
                }
            }

            if (!isThereDuplicate) {
                treasures.add(new Treasure(0, randTreasure));
            }

        }

        int chestActualCapacity = rand.nextInt(CHEST_CAPACITY) + 5;

        double oneCellCapacity = chestActualCapacity / treasures.size();

        for (Treasure treasure : treasures) {
            treasure.setAmount(oneCellCapacity);
            value += treasure.getAmount() * treasure.getTreasureType().getCost();
        }

    }

    public long getValue() {
        return value;
    }

    public ArrayList<Treasure> getTreasures() {
        return treasures;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Treasure treasure : treasures) {
            sb.append(treasure)
                    .append("\n");
        }
        return sb.toString();
    }
}
