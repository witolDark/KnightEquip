package Commands;

import Knight.Inventory;

public class ShowInventoryCommand implements ICommand {
    private final Inventory inventory;

    public ShowInventoryCommand(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public void execute() {
        inventory.showInventory();
    }
}
