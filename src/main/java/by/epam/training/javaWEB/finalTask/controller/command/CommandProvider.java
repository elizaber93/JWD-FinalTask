package by.epam.training.javaWEB.finalTask.controller.command;

import by.epam.training.javaWEB.finalTask.controller.command.impl.*;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private Map<CommandName, Command> commands = new HashMap<>();

    public CommandProvider() {
        //Add all commands
        commands.put(CommandName.ADD_ARTICLE, new AddArticle());
        commands.put(CommandName.UPDATE_SUPPLIER, new UpdateSupplier());
        commands.put(CommandName.SAVE_USER_DETAIL, new SaveUserDetail());
        commands.put(CommandName.GOTO_EDIT_PROFILE, new GoToEditProfile());
        commands.put(CommandName.LOGOUT, new LogOut());
        commands.put(CommandName.GOTO, new GoTo());
        commands.put(CommandName.CHANGELOC,new ChangeLoc());
        commands.put(CommandName.LOGIN, new LogIn());
        commands.put(CommandName.REGISTRATION, new Registration());
        commands.put(CommandName.ADD_SUPPlY, new AddSupply());
        commands.put(CommandName.ADD_SUPPLIER, new AddSupplier());
        commands.put(CommandName.SEE_SUPPLIERS, new SeeSupplierList());
    }


    public Command takeCommand(String name) {
        CommandName commandName;
        commandName = CommandName.valueOf(name.toUpperCase());
        return commands.get(commandName);

    }

}
