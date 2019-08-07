package fourth.controller;

import fourth.Main;
import fourth.model.Chest;
import fourth.model.Treasure;
import fourth.model.TreasureType;
import fourth.view.ConsoleView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SaverLoader {

    private static final String MONEY_DIVIDER = "----";
    private static final String CHEST_DIVIDER = "---";
    private static final String TREASURE_DIVIDER = "--";
    private static final String TREASURE_ATTRIBUTES_DIVIDER = "-";

    public static void save(ConsoleView consoleView) {
        try {
            FileWriter fw = new FileWriter("/home/strizhonov/IdeaProjects/saved.txt");

            long money = consoleView.getMoney();

            fw.write(String.valueOf(money));
            fw.write(MONEY_DIVIDER);

            ArrayList<Chest> cList = consoleView.getPicked();

            for (int i = 0; i < cList.size(); i++) {
                ArrayList<Treasure> treasures = cList.get(i).getTreasures();

                for (int j = 0; j < treasures.size(); j++) {
                    fw.write(String.valueOf(treasures.get(j).getCapacity()));
                    fw.write(TREASURE_ATTRIBUTES_DIVIDER);
                    fw.write(treasures.get(j).getTreasureType().name());

                    if (j != treasures.size() - 1) {
                        fw.write(TREASURE_DIVIDER);
                    }
                }

                if (i != cList.size() - 1) {
                    fw.write(CHEST_DIVIDER);
                }

            }

            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ConsoleView load() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("/home/strizhonov/IdeaProjects/saved.txt"));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }

            String sFile = sb.toString();

            String money = sFile.split(MONEY_DIVIDER)[0];
            String sBulkChests = sFile.split(MONEY_DIVIDER)[1];

            String[] sChests = sBulkChests.split(CHEST_DIVIDER);

            ArrayList<Chest> cList = new ArrayList<>();

            for (String sChest : sChests) {
                Chest chest = new Chest();
                String[] sTreasures = sChest.split(TREASURE_DIVIDER);

                for (String sTreasure : sTreasures) {

                    String sCapacity = sTreasure.split(TREASURE_ATTRIBUTES_DIVIDER)[0];
                    String sTreasureType = sTreasure.split(TREASURE_ATTRIBUTES_DIVIDER)[1];

                    TreasureType type;
                    switch (sTreasureType.trim()) {
                        case "DIAMOND":
                            type = TreasureType.values()[1];
                            break;
                        case "SILVER":
                            type = TreasureType.values()[2];
                            break;
                        case "RUBY":
                            type = TreasureType.values()[3];
                            break;
                        case "BITCOIN":
                            type = TreasureType.values()[4];
                            break;
                        case "GOLD":
                        default:
                            type = TreasureType.values()[0];
                            break;
                    }

                    double capacity = Double.valueOf(sCapacity);
                    chest.getTreasures().add(new Treasure(capacity, type));
                }

                cList.add(chest);
            }

            ConsoleView consoleView = new ConsoleView(Long.valueOf(money));
            consoleView.setPicked(cList);

            return consoleView;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ConsoleView(Main.getStartMoney());

    }

}
