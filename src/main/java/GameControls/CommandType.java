package GameControls;

import lombok.Getter;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

@Getter
public enum CommandType {
    GO("go"),
    LOOK("look"),
    BAG("bag"),
    GET("get"),
    DROP("drop"),
    HELP("help"),
    EXIT("exit");

    private final String commandAction;

    CommandType(String commandAction) {
        this.commandAction = commandAction;
    }
    public static @Nullable CommandType convertingStringToCommandType(String text) {
        return Arrays.stream(CommandType.values()).filter(commandType -> commandType.commandAction.equalsIgnoreCase(text))
                .findFirst()
                .orElse(null);
    }
}
