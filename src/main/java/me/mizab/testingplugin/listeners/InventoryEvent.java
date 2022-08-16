package me.mizab.testingplugin.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryEvent implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        if (event.getCurrentItem() == null)
            return;

        if (event.getCurrentItem().getItemMeta().getCustomModelData() == 10){
            player.sendMessage("hi");
        }
        event.setCancelled(true);
    }
}
