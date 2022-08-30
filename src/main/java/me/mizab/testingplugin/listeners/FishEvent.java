package me.mizab.testingplugin.listeners;

import me.mizab.testingplugin.utility.CoolDown;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.FishHook;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;

public class FishEvent implements Listener {
    @EventHandler
    public void onFish(PlayerFishEvent event) {
        Player player = event.getPlayer();
        FishHook hook = event.getHook();
        ItemStack currentItem = player.getInventory().getItemInMainHand();
        int itemCustomModelData = currentItem.getItemMeta().getCustomModelData();
        if (itemCustomModelData == 1) {
            if (event.getState().equals(PlayerFishEvent.State.REEL_IN) || event.getState().equals(PlayerFishEvent.State.IN_GROUND)) {
                if (CoolDown.checkCoolDown(player)) {
                    Location playerLocation = player.getLocation();
                    Location hookLocation = hook.getLocation();

                    Location difference = hookLocation.subtract(playerLocation);
                    player.setVelocity(difference.toVector().multiply(0.4));
                    CoolDown.setCoolDown(player, 3);
                } else {
                    player.sendMessage(ChatColor.RED + "Wait for " + CoolDown.getTimeLeftInSeconds() + " secs to use the item");
                }
            }
        }
    }
}
