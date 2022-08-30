package me.mizab.testingplugin;

import me.mizab.testingplugin.commands.FlyCommand;
import me.mizab.testingplugin.commands.GiveGrapplingHookCommand;
import me.mizab.testingplugin.commands.MenuCommand;
import me.mizab.testingplugin.commands.NightVisionCommand;
import me.mizab.testingplugin.listeners.*;
import org.bukkit.plugin.java.JavaPlugin;

public final class TestingPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        // events
        getServer().getPluginManager().registerEvents(new InventoryEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerEvent(), this);
        getServer().getPluginManager().registerEvents(new FishEvent(), this);
        getServer().getPluginManager().registerEvents(new MoveEvent(), this);
        getServer().getPluginManager().registerEvents(new BreakEvent(), this);
        // commands
        getCommand("menu").setExecutor(new MenuCommand());
        getCommand("nightvision").setExecutor(new NightVisionCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("givehook").setExecutor(new GiveGrapplingHookCommand());
    }
}
