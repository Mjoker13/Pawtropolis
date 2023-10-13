package Controller;

import Domain.CommandDomain.Command;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
public class CommandController {
    private Map<Class<? extends Command>, List<Command>> commands;

    public CommandController(Map<Class<? extends Command>, List<Command>> commands) {
        this.commands = commands;
    }

    private <T extends Command> List<T> getAllCommandsForType(Class<T> commandClass) {
        if (commands.isEmpty()) {
            return Collections.emptyList();
        }
        return commands.entrySet().stream()
                .filter(entry -> commandClass.isAssignableFrom(entry.getKey()))
                .map(Map.Entry::getValue)
                .flatMap(Collection::stream)
                .map(commandClass::cast)
                .collect(Collectors.toList());
    }

    public <T extends Command> T getClass(Class<T> commandClass, String[] nameClass) {
        return getAllCommandsForType(commandClass).stream()
                .filter(s -> s.getName().equalsIgnoreCase(nameClass[0]))
                .findFirst().orElse(null);
    }

}
