package me.mizab.testingplugin.utility;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GrapplingHook {
    public static void createGrapplingHook(Player player) {
        ItemStack rod = new ItemStack(Material.FISHING_ROD);
        ItemMeta rodMeta = rod.getItemMeta();

        rodMeta.setDisplayName(ChatColor.GOLD + "Grappling Hook");
        rodMeta.setCustomModelData(1);

        rod.setItemMeta(rodMeta);

        player.getInventory().addItem(rod);
    }
}
