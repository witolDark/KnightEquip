package Inventory;

public abstract class Item {
    protected Integer level;
    protected String name;
    protected Double subStatValue;

    public Integer getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public Double getSubStatValue() {
        return subStatValue;
    }
}
