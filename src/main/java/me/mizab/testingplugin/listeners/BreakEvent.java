package me.mizab.testingplugin.listeners;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class BreakEvent implements Listener {
    @EventHandler
    public void onBreakBlock(BlockBreakEvent event) {
        EntityType[] mobs = Stream.of(EntityType.values())
                .filter(EntityType::isSpawnable)
                .toArray(EntityType[]::new);
        EntityType randomEntity = mobs[ThreadLocalRandom.current().nextInt(mobs.length)];

        Player player = event.getPlayer();
        Location location = event.getBlock().getLocation().add(0.5, 0.5, 0.5);

        Entity entity = player.getWorld().spawnEntity(location, randomEntity);
        entity.addScoreboardTag("test");
    }
}
