package fr.tathan.mom.mechanics.effectRange;

import fr.tathan.mom.Utils;
import io.th0rgal.oraxen.api.OraxenItems;
import io.th0rgal.oraxen.mechanics.MechanicFactory;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.util.BoundingBox;

import java.util.Collection;

public class EffectRangeMechanicManager implements Listener {

    private final MechanicFactory factory;

    public EffectRangeMechanicManager(MechanicFactory factory) {
        this.factory = factory;
    }


    @EventHandler
    public void onEntityAttack(EntityDamageByEntityEvent event) {

        Entity damager = event.getDamager();
        if (!(damager instanceof Player)) return;

        Player player = (Player) damager;

        /** Oraxen Check */
        ItemStack item = player.getInventory().getItemInMainHand();
        String itemID = OraxenItems.getIdByItem(item);
        EffectRangeMechanic mechanic = (EffectRangeMechanic) factory.getMechanic(item);

        if (factory.isNotImplementedIn(itemID)) return;
        if (mechanic == null) return;

        Location location = player.getLocation();

        BoundingBox box = BoundingBox.of(player.getWorld().getBlockAt(location)).expand(mechanic.getSize());
        PotionEffect effect = Utils.getPotionEffect(mechanic);
        if (effect == null) return;

        Collection<Entity> entities = player.getWorld().getNearbyEntities(box);
        for (Entity entity1 : entities) {
            if(entity1 instanceof LivingEntity livingEntity1) {
                livingEntity1.addPotionEffect(effect);
            }
        }
    }

}
