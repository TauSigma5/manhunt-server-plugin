package com.tauflight.spigot.auto_refresh;

import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.*;

public class refreshserver implements CommandExecutor {

    // This method is called, when somebody uses our command
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            try {
                doTheDeed();
            } catch (InterruptedException e) {
                int stuff = Bukkit.broadcastMessage("restart failed");
                return false;
            }
        }

        return true;
    }

    public void doTheDeed() throws InterruptedException {
        final String workingDir = "/home/server1/Documents/manhunt-server/";
        try {
            boolean result = Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "advancement revoke @a everything");
            Bukkit.broadcastMessage("Cleared out advancements with result: " + result);

            int stuff = Bukkit.broadcastMessage("Shutting down in 30 seconds. Goodbye! :')");
            ProcessBuilder pb = new ProcessBuilder(workingDir + "refresh_world.sh");
            File log = new File(workingDir + "refresh_world.txt");
            pb.redirectErrorStream(true);
            pb.redirectOutput(Redirect.appendTo(log));
            Process p = pb.start();
        } catch (IOException e) {
            int stuff = Bukkit.broadcastMessage("Restart Failed, please contact Tau.");
        } catch (CommandException e) {
            int stuff = Bukkit.broadcastMessage("Error during restart, please contact Tau");
        }
    }
}