package fr.tathan.mom.mechanics;

import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public record EffectConfiguration(String effect, int duration, int amplifier) implements ConfigurationSerializable {

    @Override
    @NotNull
    public Map<String, Object> serialize() {
        Map<String, Object> data = new HashMap();
        data.put("effect", this.effect);
        data.put("duration", this.duration);
        data.put("amplifier", this.amplifier);

        return data;
    }

    public static EffectConfiguration deserialize(@NotNull Map<?, ?> args) {
        return new EffectConfiguration((String) args.get("effect"), (Integer) args.get("duration"), (Integer) args.get("amplifier"));
    }


}
