package fr.tathan.mom.mechanics.trap;

import io.th0rgal.oraxen.OraxenPlugin;
import io.th0rgal.oraxen.mechanics.Mechanic;
import io.th0rgal.oraxen.mechanics.MechanicFactory;
import io.th0rgal.oraxen.mechanics.MechanicsManager;
import org.bukkit.configuration.ConfigurationSection;


public class TrapBlockMechanicFactory extends MechanicFactory  {

    public TrapBlockMechanicFactory(String id) {
        super(id);
        MechanicsManager.registerListeners(OraxenPlugin.get(), id, new TrapBlockMechanicManager(this));

    }

    @Override
    public Mechanic parse(ConfigurationSection configurationSection) {
        TrapBlockMechanic mechanic = new TrapBlockMechanic(this, configurationSection);
        addToImplemented(mechanic);
        return mechanic;
    }
}
