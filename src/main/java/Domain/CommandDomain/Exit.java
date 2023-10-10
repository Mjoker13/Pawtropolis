package Domain.CommandDomain;

import Controller.PlayerController;
import lombok.extern.java.Log;

@Log
public class Exit extends CommandClassWithoutInput{

    public Exit() {
        super("exit");
    }

    @Override
    public void runCommand() {
        log.info("Thank you for your time, GoodBye ");
    }
}
