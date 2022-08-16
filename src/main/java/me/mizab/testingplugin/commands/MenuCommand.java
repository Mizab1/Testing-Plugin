package me.mizab.testingplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MenuCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        Inventory inventory = Bukkit.createInventory(player, 9, "Test Inv");
        ItemStack item = new ItemStack(Material.WOODEN_HOE);
        ItemMeta itemMeta = item.getItemMeta();

        itemMeta.setDisplayName("Test item");
        itemMeta.setCustomModelData(10);
        item.setItemMeta(itemMeta);

        inventory.addItem(item);

        player.openInventory(inventory);

        return true;
    }
}
