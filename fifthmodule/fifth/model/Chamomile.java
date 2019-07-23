package fifth.model;

import java.util.Objects;

public class Chamomile extends Flower {

    public Chamomile(FlowerBuilder flowerBuilder) {
        super(flowerBuilder.color);
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Chamomile)) {
            return false;
        }
        Chamomile chamomile = (Chamomile) o;
        return Objects.equals(color, chamomile.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, this.getClass().getSimpleName());
    }

}
