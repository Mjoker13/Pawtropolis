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

    private final String commandName;

    CommandType(String commandName) {
        this.commandName = commandName;
    }

    public static @Nullable CommandType convertString(String text) {
        return Arrays.stream(CommandType.values()).filter(commandType -> commandType.commandName.equalsIgnoreCase(text))
                .findFirst()
                .orElse(null);
    }
    public static boolean isCommandValid(String text){
        return Arrays.stream(CommandType.values()).anyMatch(a -> text.equalsIgnoreCase(a.name()));}
}
