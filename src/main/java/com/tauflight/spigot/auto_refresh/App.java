package com.tauflight.spigot.auto_refresh;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;

public final class App extends JavaPlugin {
    @Override
    public void onEnable() {
        this.getCommand("refreshserver").setExecutor(new refreshserver());
        this.getCommand("ishoe").setExecutor(new ishoe());
        this.getCommand("switchversion").setExecutor(new switchversion());
        getServer().getPluginManager().registerEvents(new MyListener(), this);
        getLogger().info("Loaded server refresh command");
    }

    @Override
    public void onDisable() {
        getLogger().info("Unloaded server refresh command");
    }
}