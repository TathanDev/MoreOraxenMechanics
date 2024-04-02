package fr.tathan.mom.commands;

import fr.tathan.mom.MOMPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class VersionCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        commandSender.sendMessage("MOM version : " + MOMPlugin.get().getDescription().getVersion());
        return false;
    }
}
