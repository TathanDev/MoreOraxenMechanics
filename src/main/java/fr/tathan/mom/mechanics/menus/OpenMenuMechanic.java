package fr.tathan.mom.mechanics.menus;

import io.th0rgal.oraxen.mechanics.Mechanic;
import io.th0rgal.oraxen.mechanics.MechanicFactory;
import io.th0rgal.oraxen.mechanics.provided.gameplay.block.BlockMechanic;
import org.bukkit.configuration.ConfigurationSection;

public class OpenMenuMechanic extends BlockMechanic {

    private final String menu;
    public OpenMenuMechanic(MechanicFactory mechanicFactory, ConfigurationSection section) {
        super(mechanicFactory, section);
        this.menu = section.getString("menu");
    }

    public String getMenu() {
        return menu;
    }
}
