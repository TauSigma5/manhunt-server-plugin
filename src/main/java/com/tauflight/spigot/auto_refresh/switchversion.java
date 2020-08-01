package com.tauflight.spigot.auto_refresh;

import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class switchversion implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label,
             String[] args) {
        if (args.length > 1) {
            return false;
        } else if (args.length == 0) {
            return false;
        }

        if (!checkValidity(args[0])) {
            return false;
        } else {
            doTheDeed(args[0]);
        }

        return true;
    }

    public boolean checkValidity(String input) {
        String[] versions = new String[]{"1.16.1", "1.15.2"};

        // Convert String Array to List
        List<String> list = Arrays.asList(versions);

        if (list.contains(input)){
            return true;
        } else {
            return false;
        }

    }

    public void doTheDeed(String version) {
        final String workingDir = "/home/server1/Documents/manhunt-server/";
        try {
            int stuff = Bukkit.broadcastMessage("Shutting down in 30 seconds. Goodbye! :')");
            ProcessBuilder pb = new ProcessBuilder(workingDir + "change_version.sh", version);
            File log = new File(workingDir + "change_version.txt");
            pb.redirectErrorStream(true);
            pb.redirectOutput(Redirect.appendTo(log));
            Process p = pb.start();
        } catch (IOException e) {
            int stuff = Bukkit.broadcastMessage("Restart Failed, please contact Tau.");
            Bukkit.broadcastMessage(e.toString());
        } catch (CommandException e) {
            int stuff = Bukkit.broadcastMessage("Error during restart, please contact Tau");
        }
    }
}