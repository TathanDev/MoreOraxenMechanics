package fr.tathan.mom.mechanics.effects;

import fr.tathan.mom.Utils;
import io.th0rgal.oraxen.api.OraxenItems;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class EffectsMechanicManager implements Listener {

    private final EffectsMechanicFactory factory;

    public EffectsMechanicManager(EffectsMechanicFactory factory) {
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
        System.out.println(itemID);
        EffectsMechanic mechanic = (EffectsMechanic) factory.getMechanic(item);
        if (factory.isNotImplementedIn(itemID)) return;
        if (mechanic == null) return;
        System.out.println(mechanic.getEffects());

        mechanic.getEffects().forEach(effect -> {
            livingEntity.addPotionEffect(Utils.getPotionEffect(effect));
        });
    }

}
