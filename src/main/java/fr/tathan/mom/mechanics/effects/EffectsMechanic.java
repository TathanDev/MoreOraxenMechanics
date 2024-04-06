package fr.tathan.mom.mechanics.effects;

import fr.tathan.mom.mechanics.EffectConfiguration;
import io.th0rgal.oraxen.mechanics.Mechanic;
import io.th0rgal.oraxen.mechanics.MechanicFactory;
import io.th0rgal.oraxen.utils.logs.Logs;
import org.bukkit.configuration.ConfigurationSection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class EffectsMechanic extends Mechanic {

    private List<EffectConfiguration> effects;

    protected EffectsMechanic(MechanicFactory mechanicFactory, ConfigurationSection section) {
        super(mechanicFactory, section);

        this.effects = new ArrayList();
        if (section.isList("list")) {
            Iterator var4 = section.getList("list", new ArrayList()).iterator();

            label132:
            while(true) {
                while(true) {
                    if (!var4.hasNext()) {
                        break label132;
                    }

                    Object effectObject = var4.next();

                    if (effectObject instanceof EffectConfiguration) {
                        EffectConfiguration effectConfiguration = (EffectConfiguration)effectObject;

                        try {
                            this.effects.add(new EffectConfiguration(effectConfiguration.effect(), effectConfiguration.duration(), effectConfiguration.amplifier()));
                        } catch (ClassCastException var13) {
                            Logs.logError("Invalid effectConfiguration location: " + effectConfiguration + " for item: " + this.getItemID());
                        }
                    }
                    if (effectObject instanceof Map) {
                        Map<?, ?> effectMap = (Map)effectObject;

                        try {
                            this.effects.add(EffectConfiguration.deserialize(effectMap));
                        } catch (ClassCastException var13) {
                            Logs.logError("Invalid effect location: " + effectMap + " for item: " + this.getItemID());
                        }

                    }

                }
            }
        }
    }

    public List<EffectConfiguration> getEffects() {
        return effects;
    }

}
