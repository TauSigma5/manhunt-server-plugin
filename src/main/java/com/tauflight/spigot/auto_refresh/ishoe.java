package com.tauflight.spigot.auto_refresh;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ishoe implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 2) {
            return false;
        }

        Player player = Bukkit.getPlayer(args[0]);
        
        if (player == null) {
            return false;
        } else {
            giveHoe(player, recombine(args));
            return true;
        }
        
    }

    public String recombine(String[] args) {
        int i;
        String result = "";

        for (i = 1; i < args.length; i++) {
            result = result + args[i] + " ";
        }

        return result;
    }

    public void giveHoe(Player player, String name) {
        ItemStack hoe = new ItemStack(Material.GOLDEN_HOE);
        ItemMeta meta = hoe.getItemMeta();
        meta.setDisplayName(name);
        hoe.setItemMeta(meta);
        player.getInventory().addItem(hoe);
    }
}