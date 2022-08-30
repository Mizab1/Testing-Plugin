package me.mizab.testingplugin.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveEvent implements Listener {
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
//        player.getWorld().spawnEntity(player.getLocation(), EntityType.SHEEP);
//        Bukkit.getWorld("world").spawnEntity(new Location(Bukkit.getWorld("world"), 10, 10, 10), EntityType.SHEEP);
    }
}
