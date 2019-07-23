package second;

import java.util.Arrays;

public class Payment {

    private double totalCost;
    private Item[] items;

    public Payment() {}

    public Payment(Item[] items) {
        this.items = items;
        for (Item item : items) {
            totalCost += item.getCost();
        }
    }

    public void add(Item item) {
        totalCost += item.getCost();
        items = Arrays.copyOf(items, items.length + 1);
        items[items.length - 1] = item;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public class Item {
        private ItemType itemType;
        private double cost;

        public Item(ItemType itemType, double cost) {
            if (cost < 0d) {
                cost = 0d;
            }
            this.itemType = itemType;
            this.cost = cost;
        }

        public ItemType getItemType() {
            return itemType;
        }

        public void setItemType(ItemType itemType) {
            this.itemType = itemType;
        }

        public double getCost() {
            return cost;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }
    }

    enum ItemType {
        APPLE,
        BANANA,
        PUMPKIN,
        PINEAPPLE,
        STRAWBERRY,
        BEER
    }
}
