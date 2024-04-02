package fr.tathan.mom.mechanics.effect;

import io.th0rgal.oraxen.mechanics.Mechanic;
import io.th0rgal.oraxen.mechanics.MechanicFactory;
import org.bukkit.configuration.ConfigurationSection;

public class EffectMechanic extends Mechanic {

    private final String effect;
    private final int duration;
    private int amplifier;

    protected EffectMechanic(MechanicFactory mechanicFactory, ConfigurationSection section) {
        super(mechanicFactory, section);
        this.effect = section.getString("effect");
        this.duration = section.getInt("duration");
        this.amplifier = section.getInt("amplifier", 1);
    }

    public String getEffect() {
        return effect;
    }

    public int getDuration() {
        return duration;
    }

    public int getAmplifier() {
        return amplifier;
    }
}
