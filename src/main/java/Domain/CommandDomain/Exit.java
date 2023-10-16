package Domain.CommandDomain;


import lombok.extern.java.Log;

@Log
public class Exit extends Command{

    @Override
    public void runCommand() {
        log.info("Thank you for your time, GoodBye ");
    }
}
