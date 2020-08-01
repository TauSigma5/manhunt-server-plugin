package com.tauflight.spigot.auto_refresh;

import org.bukkit.event.Listener;

import java.io.BufferedWriter;
import java.io.FileWriter;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MyListener implements Listener {
    @EventHandler
    public void onPlayerJoin(final PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String name = player.getName();

        if (!player.hasPlayedBefore()) {
            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "advancement revoke " + name + " everything");
            if (name.equalsIgnoreCase("0wlflight")) {
                ItemStack hoe = new ItemStack(Material.GOLDEN_HOE);
                ItemMeta meta = hoe.getItemMeta();
                meta.setDisplayName("Sofia");
                hoe.setItemMeta(meta);
                player.getInventory().addItem(hoe);
            }
        }
    }
}