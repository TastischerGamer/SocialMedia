package me.TastischerGamer.SocialMedia.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.TastischerGamer.SocialMedia.main.Main;

public class socialconfig implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(command.getName().equalsIgnoreCase("socialconfig")) {
			
			if(sender.hasPermission("social.config")) {
				
				Main.plugin.reloadConfig();
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.plugin.getConfig().getString("system.prefix")) + ChatColor.translateAlternateColorCodes('&', Main.plugin.getConfig().getString("system.configrl")));
				
			}else{
				
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.plugin.getConfig().getString("system.prefix")) + ChatColor.translateAlternateColorCodes('&', Main.plugin.getConfig().getString("system.noPerms")));
				
			}
			
		}
		
		return false;
	}

}
