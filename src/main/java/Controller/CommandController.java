package Controller;

import Domain.CommandDomain.CommandClass;

import java.util.*;
import java.util.stream.Collectors;

public class CommandController {
    private Map<Class<? extends CommandClass>, List<CommandClass>> commands;

    private  <T extends CommandClass> List<T> getAllCommandsForType(Class<T> commandClass){
        if(commands.isEmpty()){
            return Collections.emptyList();
        }
        return commands.entrySet().stream()
                .filter(entry-> commandClass.isAssignableFrom(entry.getKey()))
                .map(Map.Entry::getValue)
                .flatMap(Collection::stream)
                .map(commandClass::cast)
                .collect(Collectors.toList());
    }

    public <T extends CommandClass> T getClass(Class<T> commandClass, String[] nameClass){
        return getAllCommandsForType(commandClass).stream()
                .filter(s -> s.getName().equalsIgnoreCase(nameClass[0]))
                .findFirst().orElse(null);
    }


}
