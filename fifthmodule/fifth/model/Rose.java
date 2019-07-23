package fifth.model;

import java.util.Objects;

public class Rose extends Flower {

    public Rose(FlowerBuilder flowerBuilder) {
        super(flowerBuilder.color);
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Rose)) {
            return false;
        }
        Rose rose = (Rose) o;
        return Objects.equals(color, rose.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, this.getClass().getSimpleName());
    }

}
