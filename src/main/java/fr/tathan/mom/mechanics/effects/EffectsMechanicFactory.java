package fr.tathan.mom.mechanics.effects;

import io.th0rgal.oraxen.OraxenPlugin;
import io.th0rgal.oraxen.mechanics.Mechanic;
import io.th0rgal.oraxen.mechanics.MechanicFactory;
import io.th0rgal.oraxen.mechanics.MechanicsManager;
import org.bukkit.configuration.ConfigurationSection;


public class EffectsMechanicFactory extends MechanicFactory  {

    public EffectsMechanicFactory(String id) {
        super(id);
        MechanicsManager.registerListeners(OraxenPlugin.get(), id, new EffectsMechanicManager(this));

    }

    @Override
    public Mechanic parse(ConfigurationSection configurationSection) {
        Mechanic mechanic = new EffectsMechanic(this, configurationSection);
        addToImplemented(mechanic);
        return mechanic;
    }
}
