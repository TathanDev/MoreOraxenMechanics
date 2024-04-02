package fr.tathan.mom;

import fr.tathan.mom.commands.VersionCommand;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public class MOMPlugin extends JavaPlugin {

    static MOMPlugin main;
    @Override
    public void onEnable() {
        System.out.println("Plugin Activated");
        System.out.println("Plugin Activated");

        getServer().getPluginManager().registerEvents(new EventListeners(), this);

        getCommand("version").setExecutor(new VersionCommand());
    }

    public MOMPlugin() {
        main = this;
    }

    public static MOMPlugin get() {
        return main;
    }

    @Override
    public void onDisable() {
        HandlerList.unregisterAll(this);
    }
}
