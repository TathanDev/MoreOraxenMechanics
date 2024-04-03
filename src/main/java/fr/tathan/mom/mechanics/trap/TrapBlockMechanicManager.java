package fr.tathan.mom.mechanics.trap;

import com.extendedclip.deluxemenus.menu.Menu;
import fr.tathan.mom.Utils;
import io.th0rgal.oraxen.api.OraxenBlocks;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;

public class TrapBlockMechanicManager implements Listener {

    private final TrapBlockMechanicFactory factory;

    public TrapBlockMechanicManager(TrapBlockMechanicFactory factory) {
        this.factory = factory;
    }

    @EventHandler
    public void playerInteractBlock(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Location playerLoc = event.getPlayer().getLocation();

        Location blockLocation = new Location(player.getWorld(), playerLoc.getX(), playerLoc.getY() - 0.5, playerLoc.getZ());

        Block block = player.getWorld().getBlockAt(blockLocation);
        if (OraxenBlocks.getOraxenBlock(block.getBlockData()) == null) return;

        TrapBlockMechanic mechanic = (TrapBlockMechanic) factory.getMechanic(OraxenBlocks.getOraxenBlock(block.getBlockData()).getItemID());
        if (mechanic == null) return;

        PotionEffect effect = Utils.getPotionEffect(mechanic);
        if (effect == null) return;

        event.getPlayer().addPotionEffect(effect);
    }
}
