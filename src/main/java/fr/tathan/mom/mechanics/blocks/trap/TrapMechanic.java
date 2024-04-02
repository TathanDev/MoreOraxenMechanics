package fr.tathan.mom.mechanics.blocks.trap;

import io.th0rgal.oraxen.mechanics.MechanicFactory;
import io.th0rgal.oraxen.mechanics.provided.gameplay.block.BlockMechanic;
import org.bukkit.configuration.ConfigurationSection;

public class TrapMechanic extends BlockMechanic {

    private final String effect;
    private final int duration;
    private int amplifier;

    protected TrapMechanic(MechanicFactory mechanicFactory, ConfigurationSection section) {
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
