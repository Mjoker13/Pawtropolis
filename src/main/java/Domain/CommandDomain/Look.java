package Domain.CommandDomain;

public class Look extends Command{

    public Look() {
        super("look");
    }
    @Override
   public void runCommand() {
        getMapController().showsRoomInformation();
    }
}
