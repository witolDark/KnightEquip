package Commands;

import Knight.Inventory;

public class ShowChangeWeaponCommand implements ICommand {
    private final Inventory inventory;

    public ShowChangeWeaponCommand(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public void execute() {
        inventory.showChangeWeapon();
    }
}
