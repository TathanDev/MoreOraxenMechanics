package fr.tathan.mom.mechanics.effectRange;

import io.th0rgal.oraxen.OraxenPlugin;
import io.th0rgal.oraxen.mechanics.Mechanic;
import io.th0rgal.oraxen.mechanics.MechanicFactory;
import io.th0rgal.oraxen.mechanics.MechanicsManager;
import org.bukkit.configuration.ConfigurationSection;


public class EffectRangeMechanicFactory extends MechanicFactory  {

    public EffectRangeMechanicFactory(String id) {
        super(id);
        MechanicsManager.registerListeners(OraxenPlugin.get(), id, new EffectRangeMechanicManager(this));

    }

    @Override
    public Mechanic parse(ConfigurationSection configurationSection) {
        Mechanic mechanic = new EffectRangeMechanic(this, configurationSection);
        addToImplemented(mechanic);
        return mechanic;
    }
}
