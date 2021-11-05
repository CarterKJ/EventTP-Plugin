package me.arrows.eventtp;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetEvent implements CommandExecutor {

    private Main plugin;

    public SetEvent(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("set-event").setExecutor(this);
    }

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("Player only command!");
            return false;
        }
        Player p = (Player) commandSender;
        if (!p.hasPermission("event.set-event")) {
            p.sendMessage(Color("&cYou don't have enough permissions!"));
            return false;
        }

            String name = "event".toLowerCase();
        if (plugin.getConfig().get(name) != null) {
            p.sendMessage(Color("&cYou have to delete the current event!"));
            return false;
        }
            Location loc = p.getLocation();
            plugin.getConfig().set(name + ".World", loc.getWorld().getName());
            plugin.getConfig().set(name + ".X", loc.getX());
            plugin.getConfig().set(name + ".Y", loc.getY());
            plugin.getConfig().set(name + ".Z", loc.getZ());
            plugin.getConfig().set(name + ".Pitch", loc.getPitch());
            plugin.getConfig().set(name + ".Yaw", loc.getYaw());
            plugin.saveConfig();
            p.sendMessage(Color("&aEvent set!"));
            Bukkit.getOnlinePlayers().forEach(players -> p.sendTitle("New Event Started!", "'/tp-event' to TP", 4, 70, 3));
            return true;

        }

            private String Color (String s){
                return ChatColor.translateAlternateColorCodes('&', s);
            }
}