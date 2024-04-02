package fr.tathan.mom.mechanics.blocks.trap;

import io.th0rgal.oraxen.OraxenPlugin;
import io.th0rgal.oraxen.mechanics.Mechanic;
import io.th0rgal.oraxen.mechanics.MechanicFactory;
import io.th0rgal.oraxen.mechanics.MechanicsManager;
import org.bukkit.configuration.ConfigurationSection;

public class TrapMechanicFactory extends MechanicFactory {
    public TrapMechanicFactory(String id) {
        super(id);
        MechanicsManager.registerListeners(OraxenPlugin.get(), id, new TrapMechanicManager(this));

    }

    @Override
    public Mechanic parse(ConfigurationSection configurationSection) {
        Mechanic mechanic = new TrapMechanic(this, configurationSection);
        addToImplemented(mechanic);
        return mechanic;
    }
}
