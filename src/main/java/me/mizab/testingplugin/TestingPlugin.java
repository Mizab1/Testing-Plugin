package me.mizab.testingplugin;

import me.mizab.testingplugin.commands.MenuCommand;
import me.mizab.testingplugin.listeners.InventoryEvent;
import me.mizab.testingplugin.listeners.PlayerEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class TestingPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        // events
        getServer().getPluginManager().registerEvents(new InventoryEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerEvent(), this);
        // commands
        getCommand("menu").setExecutor(new MenuCommand());
    }
}
