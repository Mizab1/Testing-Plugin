package me.mizab.testingplugin.commands;

import me.mizab.testingplugin.utility.GrapplingHook;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GiveGrapplingHookCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            if (player.hasPermission("testingplugin.canGetGrapplingHook")) {
                GrapplingHook.createGrapplingHook(player);
            }
        }
        return true;
    }
}
