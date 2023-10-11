package Domain.CommandDomain;

import Controller.PlayerController;

public class BagButton extends Command{
    public BagButton(PlayerController playerController) {
        super("bag",playerController);
    }

    @Override
    public void runCommand() {
        getPlayerController().showsBagInformation();
    }
}
