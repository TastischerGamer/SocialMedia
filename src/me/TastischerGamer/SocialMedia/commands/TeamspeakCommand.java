package me.TastischerGamer.SocialMedia.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.TastischerGamer.SocialMedia.main.Main;

public class TeamspeakCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(command.getName().equalsIgnoreCase("Teamspeak")) {
			
			Player p = (Player)sender;
			FileConfiguration config = Main.plugin.getConfig();
			
			if(config.getString("ts.activated").equals("true")) {
			
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("system.prefix")) + ChatColor.translateAlternateColorCodes('&', config.getString("server.ts").replace("link", config.getString("link.teamspeak"))));
			
			}else{
				
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("system.prefix")) + ChatColor.translateAlternateColorCodes('&', config.getString("system.deactivatedmessage")));
				
			}
		}
		
		return false;
	}

}
