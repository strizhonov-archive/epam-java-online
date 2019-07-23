package fourth.model;

public class Treasure {

    private int amount;
    private double capacity;
    private TreasureType treasureType;

    public Treasure(double capacity, TreasureType treasureType) {
        this.capacity = capacity;
        this.treasureType = treasureType;

        switch (treasureType) {
            case DIAMOND:
            case RUBY:
                this.amount = (int)(capacity * 5);
                break;
            case BITCOIN:
                this.amount = (int)(capacity * 23);
                break;
            case GOLD:
            case SILVER:
            default:
                this.amount = (int)(capacity);
                break;
        }

    }

    public void setAmount(double capacity)  {
        this.capacity = capacity;

        switch (treasureType) {
            case DIAMOND:
            case RUBY:
                this.amount = (int)(capacity * 5);
                break;
            case BITCOIN:
                this.amount = (int)(capacity * 23);
                break;
            case GOLD:
            case SILVER:
            default:
                this.amount = (int)(capacity);
                break;
        }
    }

    public int getAmount() {
        return amount;
    }

    public double getCapacity() {
        return capacity;
    }

    public TreasureType getTreasureType() {
        return treasureType;
    }

    @Override
    public String toString() {
        return amount + " " + treasureType.getUnit() + " of " + treasureType.name();
    }
}
