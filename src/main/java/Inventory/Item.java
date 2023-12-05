package Inventory;

public abstract class Item {
    protected Integer level;
    protected String name;
    protected Double subStatValue;
    protected Double price;

    public Integer getLevel() {
        return level;
    }

    public Double getSubStatValue() {
        return subStatValue;
    }
}
