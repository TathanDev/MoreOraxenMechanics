package fr.tathan.mom.mechanics.menus;

import fr.tathan.mom.mechanics.effectRange.EffectRangeMechanic;
import fr.tathan.mom.mechanics.effectRange.EffectRangeMechanicManager;
import io.th0rgal.oraxen.OraxenPlugin;
import io.th0rgal.oraxen.mechanics.Mechanic;
import io.th0rgal.oraxen.mechanics.MechanicFactory;
import io.th0rgal.oraxen.mechanics.MechanicsManager;
import org.bukkit.configuration.ConfigurationSection;


public class OpenMenuMechanicFactory extends MechanicFactory  {

    public OpenMenuMechanicFactory(String id) {
        super(id);
        MechanicsManager.registerListeners(OraxenPlugin.get(), id, new OpenMenuMechanicManager(this));

    }

    @Override
    public Mechanic parse(ConfigurationSection configurationSection) {
        OpenMenuMechanic mechanic = new OpenMenuMechanic(this, configurationSection);
        addToImplemented(mechanic);
        return mechanic;
    }
}
