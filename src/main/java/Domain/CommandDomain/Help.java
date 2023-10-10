package Domain.CommandDomain;

public class Help extends CommandClassWithoutInput{
    public Help() {
        super("help");
    }

    @Override
    public void runCommand() {
        System.out.println("\n-Go <direction> \n-Look \n-Bag \n-Get <item> \n-Drop <item> \n-Exit");
    }
}
