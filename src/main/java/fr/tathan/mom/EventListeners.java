package fr.tathan.mom;

import fr.tathan.mom.mechanics.effect.EffectMechanicFactory;
import fr.tathan.mom.mechanics.effectRange.EffectRangeMechanicFactory;
import io.th0rgal.oraxen.api.OraxenItems;
import io.th0rgal.oraxen.api.events.OraxenNativeMechanicsRegisteredEvent;
import io.th0rgal.oraxen.mechanics.MechanicsManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;


public class EventListeners implements Listener {

    @EventHandler
    public void onMechanicRegister(OraxenNativeMechanicsRegisteredEvent event) {
        MechanicsManager.registerMechanicFactory("effect", new EffectMechanicFactory("effect"), true);
        MechanicsManager.registerMechanicFactory("effect_range", new EffectRangeMechanicFactory("effect_range"), true);
        //MechanicsManager.registerMechanicFactory("trap_block", new TrapMechanicFactory("trap_block"), true);

        OraxenItems.loadItems();
    }


}
