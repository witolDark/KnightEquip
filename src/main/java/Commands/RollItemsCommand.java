package Commands;

import Knight.Inventory;

public class RollItemsCommand implements ICommand {
    private final Inventory inventory;

    public RollItemsCommand(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public void execute() {
        for (int i = 0; i < 5; i++) {
            inventory.rollItem();
        }
    }
}
