package me.mizab.testingplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;
import java.util.UUID;

public class NightVisionCommand implements CommandExecutor {
    private final HashMap<UUID, Long> coolDown = new HashMap<>();

    private void giveNightVision(Player player) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 20 * 5, 1, true, false));
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            if (!this.coolDown.containsKey(player.getUniqueId())) {
                this.coolDown.put(player.getUniqueId(), System.currentTimeMillis());
                player.sendMessage("You got effect");
                giveNightVision(player);
            } else {
                long timeElapsed = (System.currentTimeMillis() - this.coolDown.get(player.getUniqueId())) / 1000;
                if (timeElapsed >= 10) {
                    giveNightVision(player);
                    this.coolDown.put(player.getUniqueId(), System.currentTimeMillis());
                } else {
                    player.sendMessage("You can't run this " + (Math.abs(10 - timeElapsed)) + " Seconds");
                }
            }
        }

        return true;
    }
}
