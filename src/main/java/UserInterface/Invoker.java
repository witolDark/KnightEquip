package UserInterface;

import Commands.ICommand;

public class Invoker {
    private ICommand showDetailsCommand;
    private ICommand showChangeWeaponCommand;
    private ICommand showChangeEquipmentCommand;
    private ICommand showInventoryCommand;
    private ICommand rollItemsCommand;

    public void setShowDetailsCommand(ICommand showDetailsCommand) {
        this.showDetailsCommand = showDetailsCommand;
    }

    public void setShowChangeWeaponCommand(ICommand showChangeWeaponCommand) {
        this.showChangeWeaponCommand = showChangeWeaponCommand;
    }

    public void setShowChangeEquipmentCommand(ICommand showChangeEquipmentCommand) {
        this.showChangeEquipmentCommand = showChangeEquipmentCommand;
    }

    public void setShowInventoryCommand(ICommand showInventoryCommand) {
        this.showInventoryCommand = showInventoryCommand;
    }

    public void setRollItemsCommand(ICommand rollItemsCommand) {
        this.rollItemsCommand = rollItemsCommand;
    }

    public void showKnightDetails() {
        showDetailsCommand.execute();
    }

    public void showChangeWeapon() {
        showChangeWeaponCommand.execute();
    }

    public void showChangeEquipment() {
        showChangeEquipmentCommand.execute();
    }

    public void showInventory() {
        showInventoryCommand.execute();
    }

    public void rollItems() {
        rollItemsCommand.execute();
    }
}
