package fr.tathan.mom.mechanics.menus;

import com.extendedclip.deluxemenus.menu.Menu;
import fr.maxlego08.menu.MenuPlugin;
import fr.maxlego08.menu.api.Inventory;
import fr.maxlego08.menu.api.InventoryManager;
import fr.maxlego08.menu.command.VCommand;
import io.th0rgal.oraxen.api.OraxenBlocks;
import io.th0rgal.oraxen.mechanics.Mechanic;
import io.th0rgal.oraxen.mechanics.provided.gameplay.furniture.FurnitureMechanic;
import io.th0rgal.oraxen.mechanics.provided.misc.custom.CustomMechanic;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Optional;

public class OpenMenuMechanicManager implements Listener {

    private final OpenMenuMechanicFactory factory;

    public OpenMenuMechanicManager(OpenMenuMechanicFactory factory) {
        this.factory = factory;
    }

    @EventHandler
    public void playerInteractBlock(PlayerInteractEvent event) {
        if (event.getAction() != Action.RIGHT_CLICK_BLOCK) return;

        Block block = event.getClickedBlock();
        Mechanic mechanic = OraxenBlocks.getOraxenBlock(block.getBlockData());
        if (mechanic == null) return;

        OpenMenuMechanic menuMechanic = (OpenMenuMechanic) factory.getMechanic(mechanic.getItemID());

        if (menuMechanic == null) return;

        System.out.println(menuMechanic.getPlugin());
        if(menuMechanic.getPlugin() == OpenMenuMechanic.Plugins.DELUXEMENUS && isPluginLoaded("DeluxeMenus")) {
            Menu menu = Menu.getMenu(menuMechanic.getMenu());
            if (menu == null) {
                System.out.println("No " + menuMechanic.getMenu() + " existing");
                return;
            }
            menu.openMenu(event.getPlayer());
        } else if (menuMechanic.getPlugin() == OpenMenuMechanic.Plugins.ZMENU && isPluginLoaded("zMenu")){
            InventoryManager inventoryManager = MenuPlugin.getInstance().getInventoryManager();
            Optional<Inventory> inventory = inventoryManager.getInventory(menuMechanic.getMenu());
            inventory.ifPresent(value -> inventoryManager.openInventory(event.getPlayer(), value));

        }
    }

    private boolean isPluginLoaded(String name) {
        return Bukkit.getPluginManager().isPluginEnabled(name);
    }

}
