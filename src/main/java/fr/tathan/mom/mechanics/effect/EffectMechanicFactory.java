package fr.tathan.mom.mechanics.effect;

import io.th0rgal.oraxen.OraxenPlugin;
import io.th0rgal.oraxen.mechanics.Mechanic;
import io.th0rgal.oraxen.mechanics.MechanicFactory;
import io.th0rgal.oraxen.mechanics.MechanicsManager;
import org.bukkit.configuration.ConfigurationSection;


public class EffectMechanicFactory extends MechanicFactory  {

    public EffectMechanicFactory(String id) {
        super(id);
        MechanicsManager.registerListeners(OraxenPlugin.get(), id, new EffectMechanicManager(this));

    }

    @Override
    public Mechanic parse(ConfigurationSection configurationSection) {
        Mechanic mechanic = new EffectMechanic(this, configurationSection);
        addToImplemented(mechanic);
        return mechanic;
    }
}
