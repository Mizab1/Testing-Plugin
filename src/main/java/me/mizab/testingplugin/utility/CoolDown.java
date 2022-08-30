package me.mizab.testingplugin.utility;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class CoolDown {
    private static final HashMap<UUID, Long> coolDownMap = new HashMap<>();
    static long delayGlobal;

    public static void setCoolDown(Player player, int seconds) {
        long delay = System.currentTimeMillis() + (seconds * 1000L);
        coolDownMap.put(player.getUniqueId(), delay);
        delayGlobal = delay;
    }

    public static boolean checkCoolDown(Player player) {
        return !coolDownMap.containsKey(player.getUniqueId()) || coolDownMap.get(player.getUniqueId()) <= System.currentTimeMillis();
    }

    public static long getTimeLeftInSeconds() {
        return (delayGlobal - System.currentTimeMillis()) / 1000;
    }
}
