package me.mizab.testingplugin.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.Set;

public class PlayerEvent implements Listener {
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event){
        Player player = event.getPlayer();

        Set<String> tags = player.getScoreboardTags();
        if (!tags.contains("canMove")){
            event.setCancelled(true);
        }
    }
}
