package fifth.model;

public class Flower {

    protected final String color;

    protected Flower(String color) {
        this.color = color;
    }

    public static class FlowerFactory {

        public static Flower getFlower(FlowerBuilder flowerBuilder) {
            switch (flowerBuilder.sFlowerType) {
                case "Tulip":
                    return new Tulip(flowerBuilder);
                case "Rose":
                    return new Rose(flowerBuilder);
                case "Chamomile":
                default:
                    return new Chamomile(flowerBuilder);
            }
        }
    }

    public static class FlowerBuilder {

        protected String color;
        protected String sFlowerType;

        public static FlowerBuilder newInstance() {
            return new FlowerBuilder();
        }

        public FlowerBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public FlowerBuilder setType(String sFlowerType) {
            this.sFlowerType = sFlowerType;
            return this;
        }

        public Flower build() {
            return FlowerFactory.getFlower(this);
        }

    }

    @Override
    public String toString() {
        return color + " " + this.getClass().getSimpleName();
    }
}
