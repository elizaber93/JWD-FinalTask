package by.epam.training.javaWEB.finalTask.controller.command;

import by.epam.training.javaWEB.finalTask.controller.command.impl.AddSupply;
import by.epam.training.javaWEB.finalTask.controller.command.impl.LogIn;
import by.epam.training.javaWEB.finalTask.controller.command.impl.Registration;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private Map<CommandName, Command> commands = new HashMap<>();

    public CommandProvider() {
        //Add all commands
        commands.put(CommandName.LOG_IN, new LogIn());
        commands.put(CommandName.REGISTRATION, new Registration());
        commands.put(CommandName.ADD_SUPPlY, new AddSupply());

    }


    public Command takeCommand(String name) {
        CommandName commandName;

        commandName = CommandName.valueOf(name.toUpperCase());

        return commands.get(commandName);
    }

}
