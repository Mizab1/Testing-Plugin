package me.mizab.testingplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class FlyCommand implements CommandExecutor {
    private final ArrayList<Player> listOfFlyingPlayers = new ArrayList<>();

    private void flyMethod(Player player) {
        if (player.hasPermission("testingplugin.fly")) {
            if (listOfFlyingPlayers.contains(player)) {
                listOfFlyingPlayers.remove(player);
                player.setAllowFlight(false);
                player.sendMessage(ChatColor.RED + "You can now not fly!");
            } else {
                listOfFlyingPlayers.add(player);
                player.setAllowFlight(true);
                player.sendMessage(ChatColor.BLUE + "You can now fly!");
            }
        }
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            if (args.length == 0) {
                flyMethod(player);
            } else {
                if (player.hasPermission("testingPlugin.others")) {
                    Player target = Bukkit.getPlayer(args[0]);
                    flyMethod(target);
                }
            }
        }

        return true;
    }
}
