package fifth;

import fifth.model.Flower;
import fifth.model.FlowerComposition;
import fifth.model.Wrapping;
import fifth.view.ConsoleView;

public class Main {

    public static void main(String[] args) {

        ConsoleView cv = new ConsoleView();

        FlowerComposition flowerComposition = new FlowerComposition();

        do {
            Flower flower = cv.getFlower();
            flowerComposition.addFlower(flower);
            cv.showComposition(flowerComposition);
        }

        while ("y".equals(cv.askIfMoreFlowersNeed()));

        Wrapping wrapping = cv.getWrapping();
        flowerComposition.setWrapping(wrapping);

        cv.showComposition(flowerComposition);

    }

}
