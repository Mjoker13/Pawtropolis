package Domain.CommandDomain;

public class Bag extends Command{
    public Bag() {
        super("bag");
    }

    @Override
    public void runCommand() {
        getPlayerController().showsBagInformation();
    }
}
