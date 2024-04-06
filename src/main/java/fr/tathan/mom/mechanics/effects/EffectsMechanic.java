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

                    Object barrierObject = var4.next();

                    System.out.println("eeee " + barrierObject);
                    if (barrierObject instanceof EffectConfiguration) {
                        EffectConfiguration effectConfiguration = (EffectConfiguration)barrierObject;
                        System.out.println("eeee " + effectConfiguration);

                        try {
                            this.effects.add(new EffectConfiguration(effectConfiguration.effect(), effectConfiguration.duration(), effectConfiguration.amplifier()));
                        } catch (ClassCastException var13) {
                            Logs.logError("Invalid effectConfiguration location: " + effectConfiguration + " for item: " + this.getItemID());
                        }
                    }
                    if (barrierObject instanceof Map) {
                        Map<?, ?> barrierMap = (Map)barrierObject;

                        try {
                            this.effects.add(EffectConfiguration.deserialize(barrierMap));
                        } catch (ClassCastException var13) {
                            Logs.logError("Invalid barrier location: " + barrierMap + " for furniture: " + this.getItemID());
                        }

                    }

                }
            }
        } else {
            System.out.println("Sad " + this.getItemID());
        }

        EffectConfiguration test = new EffectConfiguration("poison", 200, 2);
        System.out.println("test config " + test);
    }

    public List<EffectConfiguration> getEffects() {
        return effects;
    }

}
