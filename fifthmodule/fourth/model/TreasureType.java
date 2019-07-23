package fourth.model;

public enum TreasureType {

    GOLD(45, "gram(s)"),
    DIAMOND(6_000, "carat(s)"),
    SILVER(1, "g(s)"),
    RUBY(10_000, "carat(s)"),
    BITCOIN(12_000, "unit(s)");

    private String unit;
    private int cost;

    TreasureType(int cost, String unit) {
        this.unit = unit;
        this.cost = cost;
    }

    public static TreasureType getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }

    public int getCost() {
        return cost;
    }

    public String getUnit() {
        return unit;
    }

    @Override
    public String toString() {
        return " " + unit + " of " + this.name();
    }

}
