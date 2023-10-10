package Domain.CommandDomain;

import Controller.PlayerController;

public class Bag extends CommandClassWithoutInput{
    public Bag(PlayerController playerController) {
        super("bag", playerController);
    }

    @Override
    public void runCommand() {
        getPlayerController().showsBagInformation();
    }
}
