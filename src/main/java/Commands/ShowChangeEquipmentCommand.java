package Commands;

import Knight.Inventory;

public class ShowChangeEquipmentCommand implements ICommand {
    private final Inventory inventory;

    public ShowChangeEquipmentCommand(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public void execute() {
        inventory.showChangeEquipment();
    }
}
