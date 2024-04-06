package fr.tathan.mom;

import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Logger;

public class MOMPlugin extends JavaPlugin {

    MOMPlugin main;
    @Override
    public void onEnable() {
        System.out.println("Plugin Activated");
        System.out.println("Plugin Activated");

        getServer().getPluginManager().registerEvents(new EventListeners(), this);


    }

    public MOMPlugin() {
        main = this;
    }

    public MOMPlugin get() {
        return main;
    }

    @Override
    public void onDisable() {
        HandlerList.unregisterAll(this);
    }

    @NotNull
    public Logger getLogger() {
        return getServer().getLogger();
    }
}
