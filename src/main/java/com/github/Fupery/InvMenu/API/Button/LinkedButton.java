package com.github.Fupery.InvMenu.API.Button;

import com.github.Fupery.InvMenu.API.Event.MenuFactory;
import com.github.Fupery.InvMenu.API.Handler.CacheableMenu;
import com.github.Fupery.InvMenu.Utils.SoundCompat;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;

public class LinkedButton extends Button {
    private final MenuFactory linkedMenu;

    public LinkedButton(MenuFactory linkedMenu, Material material) {
        super(material);
        this.linkedMenu = linkedMenu;
    }

    public LinkedButton(MenuFactory linkedMenu, Material material, int durability) {
        super(material, durability);
        this.linkedMenu = linkedMenu;
    }

    public LinkedButton(MenuFactory linkedMenu, Material material, String displayName, String... lore) {
        super(material, displayName, lore);
        this.linkedMenu = linkedMenu;
    }

    public LinkedButton(MenuFactory linkedMenu, Material material, int durability,
                        String displayName, String... lore) {
        super(material, durability, displayName, lore);
        this.linkedMenu = linkedMenu;
    }

    public LinkedButton(MenuFactory linkedMenu, Material material, int durability, String... text) {
        super(material, durability, text);
        this.linkedMenu = linkedMenu;
    }

    public LinkedButton(MenuFactory linkedMenu, Material material, String... text) {
        super(material, text);
        this.linkedMenu = linkedMenu;
    }

    @Override
    public void onClick(Player player, ClickType clickType) {
        SoundCompat.UI_BUTTON_CLICK.play(player);
        CacheableMenu menu = linkedMenu.get(player);
        menu.getHandler().openMenu(player, menu);
    }
}
