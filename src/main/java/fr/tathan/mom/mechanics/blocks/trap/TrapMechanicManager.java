package fr.tathan.mom.mechanics.blocks.trap;

import io.th0rgal.oraxen.api.OraxenBlocks;
import io.th0rgal.oraxen.mechanics.MechanicFactory;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class TrapMechanicManager implements Listener {

    private final MechanicFactory factory;

    public TrapMechanicManager(MechanicFactory mechanicFactory) {
        this.factory = mechanicFactory;
    }

    @EventHandler
    public void onStep(PlayerMoveEvent event) {
        Block block = event.getTo().getBlock();
        TrapMechanic mech = (TrapMechanic) OraxenBlocks.getBlockMechanic(block);

        if (mech == null) {
            System.out.println("UWU");
            return;
        }
        System.out.println("WORKING  " + mech.toString());

    }

}
