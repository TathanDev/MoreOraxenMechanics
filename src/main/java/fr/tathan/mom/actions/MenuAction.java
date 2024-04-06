package fr.tathan.mom.actions;

import com.extendedclip.deluxemenus.menu.Menu;
import io.th0rgal.oraxen.shaded.actions.actions.Action;
import io.th0rgal.oraxen.shaded.actions.actions.ActionMeta;
import io.th0rgal.oraxen.shaded.actions.actions.Context;
import io.th0rgal.oraxen.shaded.jetbrains.annotations.NotNull;
import org.bukkit.entity.Player;

public class MenuAction extends Action<Player> {
    public static final String IDENTIFIER = "menu";

    public MenuAction(@NotNull ActionMeta<Player> meta) {
        super(meta);
    }

    public void run(@NotNull Player player, @NotNull Context<Player> context) {
        String menu = this.getMeta().getParsedData(player, context);
        Menu.getMenu(menu).openMenu(player);
    }
}
