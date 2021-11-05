package me.arrows.eventtp;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class tpEvent implements CommandExecutor {

    private Main plugin;

    public tpEvent (Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("tp-event").setExecutor(this);
    }

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("Player only command!");
            return false;
        }

        Player p = (Player) commandSender;
        String name = "event".toLowerCase();
        if (plugin.getConfig().get(name) == null) {
            p.sendMessage(ChatColor.RED + "No events set up");
            return false;
        }
            Location loc;
        double x = plugin.getConfig().getDouble(name + ".X");
        double y = plugin.getConfig().getDouble(name + ".Y");
        double z = plugin.getConfig().getDouble(name + ".Z");
        float yaw = (float) plugin.getConfig().getDouble(name + ".Yaw");
        float pitch = (float) plugin.getConfig().getDouble(name + ".Pitch");
        String world = plugin.getConfig().getString(name + ".World");
        loc = new Location(Bukkit.getWorld(world), x, y, z, yaw, pitch);
        p.teleport(loc);
        p.sendMessage(Color("&aYou've been teleported to &b" + name));
        return true;
    }

    private String Color (String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }
}