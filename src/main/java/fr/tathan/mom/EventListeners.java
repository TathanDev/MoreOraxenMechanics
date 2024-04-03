package fr.tathan.mom;


import fr.tathan.mom.mechanics.effect.EffectMechanicFactory;
import fr.tathan.mom.mechanics.effectRange.EffectRangeMechanicFactory;
import fr.tathan.mom.mechanics.menus.OpenMenuMechanicFactory;
import fr.tathan.mom.mechanics.trap.TrapBlockMechanicFactory;
import io.th0rgal.oraxen.api.OraxenItems;
import io.th0rgal.oraxen.api.events.OraxenNativeMechanicsRegisteredEvent;
import io.th0rgal.oraxen.mechanics.MechanicsManager;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;


public class EventListeners implements Listener {

    @EventHandler
    public void onMechanicRegister(OraxenNativeMechanicsRegisteredEvent event) {
        MechanicsManager.registerMechanicFactory("effect", new EffectMechanicFactory("effect"), true);
        MechanicsManager.registerMechanicFactory("effect_range", new EffectRangeMechanicFactory("effect_range"), true);
        MechanicsManager.registerMechanicFactory("trap_block", new TrapBlockMechanicFactory("trap_block"), true);

        if(Bukkit.getPluginManager().isPluginEnabled("DeluxeMenus")) {
            MechanicsManager.registerMechanicFactory("menu_provider", new OpenMenuMechanicFactory("menu_provider"), true);
            System.out.println("DeluxeMenus founded.");
        }

        OraxenItems.loadItems();
    }


}
