package fifth.model;

import java.util.Objects;

public class Tulip extends Flower {

    public Tulip(FlowerBuilder flowerBuilder) {
        super(flowerBuilder.color);
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Tulip)) {
            return false;
        }
        Tulip tulip = (Tulip) o;
        return Objects.equals(color, tulip.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, this.getClass().getSimpleName());
    }

}
