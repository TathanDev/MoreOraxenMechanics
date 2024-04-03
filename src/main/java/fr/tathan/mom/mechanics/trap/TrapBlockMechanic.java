package fr.tathan.mom.mechanics.trap;

import fr.tathan.mom.mechanics.effect.EffectMechanic;
import io.th0rgal.oraxen.mechanics.MechanicFactory;
import io.th0rgal.oraxen.mechanics.provided.gameplay.block.BlockMechanic;
import org.bukkit.configuration.ConfigurationSection;

public class TrapBlockMechanic extends EffectMechanic {

    public TrapBlockMechanic(MechanicFactory mechanicFactory, ConfigurationSection section) {
        super(mechanicFactory, section);
    }
}
