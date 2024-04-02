package fr.tathan.mom.mechanics.effect;

import fr.tathan.mom.Utils;
import io.th0rgal.oraxen.api.OraxenItems;
import io.th0rgal.oraxen.mechanics.MechanicFactory;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

public class EffectMechanicManager implements Listener {

    private final MechanicFactory factory;

    public EffectMechanicManager(MechanicFactory factory) {
        this.factory = factory;
    }

    @EventHandler
    public void onPlayerUse(EntityDamageByEntityEvent event) {
        Entity entity = event.getEntity();
        Entity damager = event.getDamager();
        if (!(damager instanceof Player)) return;
        if (!(entity instanceof LivingEntity)) return;

        Player player = (Player) damager;
        LivingEntity livingEntity = (LivingEntity) entity;

        ItemStack item = player.getInventory().getItemInMainHand();
        String itemID = OraxenItems.getIdByItem(item);
        EffectMechanic mechanic = (EffectMechanic) factory.getMechanic(item);
        if (factory.isNotImplementedIn(itemID)) return;
        if (mechanic == null) return;

        PotionEffect effect = Utils.getPotionEffect(mechanic);
        if (effect == null) return;
        livingEntity.addPotionEffect(effect);
    }

}
