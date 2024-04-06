package fr.tathan.mom.mechanics.menus;

import io.th0rgal.oraxen.mechanics.Mechanic;
import io.th0rgal.oraxen.mechanics.MechanicFactory;
import io.th0rgal.oraxen.utils.logs.Logs;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;

import java.io.Serializable;

public class OpenMenuMechanic extends Mechanic {

    private final String menu;
    private final Plugins plugin;
    public OpenMenuMechanic(MechanicFactory mechanicFactory, ConfigurationSection section) {
        super(mechanicFactory, section);
        Plugins plugin1;

        this.menu = section.getString("menu");
        try {
            String defaultPlugin;
            defaultPlugin = Plugins.NONE.name();

            plugin1 = Plugins.valueOf(section.getString("plugin", defaultPlugin));
        } catch (IllegalArgumentException var14) {
            Logs.logError("Use of a non-existant Plugin in block: <gold>" + this.getItemID());
            Logs.logWarning("Allowed ones are: <gold>" + "ZMENU and DELUXEMENUS");
            Logs.logWarning("Setting type to ITEM_FRAME for furniture: <gold>" + this.getItemID());
            plugin1 = Plugins.NONE;
        }

        this.plugin = plugin1;
        section.set("plugin", this.plugin.name());

    }

    public String getMenu() {
        return menu;
    }

    public Plugins getPlugin() {
        return plugin;
    }

    public enum Plugins implements Serializable{
        DELUXEMENUS,
        ZMENU,
        NONE;

        public static Plugins getPlugin(String type) {
            try {
                return valueOf(type);
            } catch (IllegalArgumentException var2) {
                Logs.logError("Invalid plugin : " + type + ", set in your blocks config.");
                if (Bukkit.getPluginManager().isPluginEnabled("DeluxeMenus")) {
                    return DELUXEMENUS;
                } else if (Bukkit.getPluginManager().isPluginEnabled("zMenu")) {
                    return ZMENU;
                }
                return NONE;
            }
        }
    }


}
