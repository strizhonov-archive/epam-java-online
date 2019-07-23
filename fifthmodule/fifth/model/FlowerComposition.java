package fifth.model;

import java.util.ArrayList;

public class FlowerComposition {

    private ArrayList<Flower> flowerList;
    private Wrapping wrapping;

    public FlowerComposition() {
        flowerList = new ArrayList<>();
    }

    public void addFlower(Flower flower) {
        flowerList.add(flower);
    }

    public ArrayList<Flower> getFlowerList() {
        return flowerList;
    }

    public void setFlowerList(ArrayList<Flower> flowerList) {
        this.flowerList = flowerList;
    }

    public Wrapping getWrapping() {
        return wrapping;
    }

    public void setWrapping(Wrapping wrapping) {
        this.wrapping = wrapping;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Flower flower : flowerList) {
            sb.append(flower.toString());
            sb.append("\n");
        }

        if (wrapping != null) {
            sb.append("and ")
                    .append(wrapping);
        }
        return sb.toString();
    }
}
