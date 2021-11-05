package me.arrows.eventtp;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class delEvent implements CommandExecutor {

    private Main plugin;

    public delEvent(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("del-event").setExecutor(this);
    }


    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("Player only command!");
            return false;
        }
        Player p = (Player) commandSender;
        if (!p.hasPermission("event.del-event")) {
            p.sendMessage(Color("&cYou don't have enough permissions!"));
            return false;
        }
        String name = "event".toLowerCase();

        plugin.getConfig().set(name, null);
        plugin.saveConfig();
        p.sendMessage(Color("&aEvent &b" +" &asuccessfully deleted!"));
        return true;
    }
    private String Color (String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }
}
