package fr.tathan.mom.mechanics.effectRange;

import fr.tathan.mom.mechanics.effect.EffectMechanic;
import io.th0rgal.oraxen.mechanics.MechanicFactory;
import org.bukkit.configuration.ConfigurationSection;

public class EffectRangeMechanic extends EffectMechanic {

    private final double size;
    private final boolean attackUser;


    protected EffectRangeMechanic(MechanicFactory mechanicFactory, ConfigurationSection section) {
        super(mechanicFactory, section);
        this.size = section.getDouble("size");
        this.attackUser = section.getBoolean("attack_user");
    }

    public double getSize() {
        return size;
    }
    public boolean getAttackUser() { return attackUser;}
}
