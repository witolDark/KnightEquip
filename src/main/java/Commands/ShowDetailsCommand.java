package Commands;

import Knight.Knight;

public class ShowDetailsCommand implements ICommand {
    private final Knight knight;

    public ShowDetailsCommand(Knight knight) {
        this.knight = knight;
    }

    @Override
    public void execute() {
        knight.showStats();
    }
}
