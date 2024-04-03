package fr.tathan.mom.mechanics.menus;

import com.extendedclip.deluxemenus.DeluxeMenusCommands;
import com.extendedclip.deluxemenus.menu.Menu;
import fr.tathan.mom.MOMPlugin;
import fr.tathan.mom.mechanics.effectRange.EffectRangeMechanic;
import io.th0rgal.oraxen.api.OraxenBlocks;
import io.th0rgal.oraxen.api.events.noteblock.OraxenNoteBlockInteractEvent;
import io.th0rgal.oraxen.mechanics.Mechanic;
import io.th0rgal.oraxen.mechanics.MechanicFactory;
import io.th0rgal.oraxen.mechanics.provided.gameplay.block.BlockMechanic;
import io.th0rgal.oraxen.mechanics.provided.gameplay.noteblock.NoteBlockMechanic;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class OpenMenuMechanicManager implements Listener {

    private final OpenMenuMechanicFactory factory;

    public OpenMenuMechanicManager(OpenMenuMechanicFactory factory) {
        this.factory = factory;
    }

    @EventHandler
    public void playerInteractBlock(PlayerInteractEvent event) {
        if(event.getAction() != Action.RIGHT_CLICK_BLOCK) return;

        Block block = event.getClickedBlock();
        if(OraxenBlocks.getOraxenBlock(block.getBlockData()) == null) return;


        OpenMenuMechanic mechanic = (OpenMenuMechanic) factory.getMechanic(OraxenBlocks.getOraxenBlock(block.getBlockData()).getItemID());

        if (mechanic == null) return;
        Menu menu = Menu.getMenu(mechanic.getMenu());
        if (menu == null) {
            System.out.println("No " + mechanic.getMenu() + " existing");
            return;
        }
        menu.openMenu(event.getPlayer(), event.getPlayer());
    }
}
