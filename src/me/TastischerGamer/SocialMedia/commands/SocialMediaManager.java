package me.TastischerGamer.SocialMedia.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import me.TastischerGamer.SocialMedia.Utils.LangUtils;
import me.TastischerGamer.SocialMedia.Utils.PluginUtils;
import me.TastischerGamer.SocialMedia.Utils.SocialUtil;
import me.TastischerGamer.SocialMedia.main.SocialMediaPlugin;

public class SocialMediaManager implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if(command.getName().equalsIgnoreCase("SocialMediaManager")) {
			
			if(sender instanceof Player) {
			
				Player p = (Player)sender;
				
				if(p.hasPermission(PluginUtils.getPermission("Socialmedia_edit"))) {
					
					if(args.length == 0) {
						
						p.sendMessage(LangUtils.getMessage("system.wrongusage"));
						
					}else if(args.length == 1) {
						
						if(args[0].equalsIgnoreCase("help")) {
							
							p.sendMessage("§7~~~~~~~~~~~~~~~~~~~~");
							p.sendMessage("§6Socialmedia Commands:");
							p.sendMessage(" §8- §7/SocialMedia add <Command>");
							p.sendMessage(" §8- §7/SocialMedia remove <Command>");
							p.sendMessage(" §8- §7/SocialMedia status <Command> <true / false>");
							p.sendMessage(" §8- §7/SocialMedia reload");
							p.sendMessage("§7~~~~~~~~~~~~~~~~~~~~");
							
						}else if(args[0].equalsIgnoreCase("reload") || args[0].equalsIgnoreCase("rl")) {
							
							SocialMediaPlugin.getInstance().reloadConfig();
							
							p.sendMessage(LangUtils.getMessage("system.configreloaded"));
							
						}else {
							
							p.sendMessage(LangUtils.getMessage("system.wrongusage"));
							
						}
						
					}else if(args.length == 2) {
						
						if(args[0].equalsIgnoreCase("add")) {
							
							SocialUtil.addCommand(p, args[1].toLowerCase());
							
	//						p.sendMessage(LangUtils.getMessage("system.added"));
							
						}else if(args[0].equalsIgnoreCase("remove")) {
							
							SocialUtil.removeCommand(p, args[1].toLowerCase());
							
	//						p.sendMessage(LangUtils.getMessage("system.removed"));
							
						}else {
							
							p.sendMessage(LangUtils.getMessage("system.wrongusage"));
							
						}
						
					}else if(args.length == 3) {
						
						if(args[0].equalsIgnoreCase("status")) {
							
							String Command = args[1].toLowerCase();
							
							if(SocialUtil.getCommands().contains(Command)) {
							
								if(args[2].equalsIgnoreCase("true")) {
									
									SocialUtil.setCommandStatus(p, Command, true);
									
									p.sendMessage(LangUtils.getMessage("system.activate"));
									
								}else if(args[2].equalsIgnoreCase("false")) {
									
									SocialUtil.setCommandStatus(p, Command, false);
									
									p.sendMessage(LangUtils.getMessage("system.deactivate"));
									
								}else {
									
									p.sendMessage(LangUtils.getMessage("system.wrongusage"));
									
								}
							
							}else {
								
								p.sendMessage(LangUtils.getMessage("system.existsnot"));
								
							}
							
						}
						
					}else {
						
						p.sendMessage(LangUtils.getMessage("system.wrongusage"));
						
					}
					
				}else {
					
					p.sendMessage(PluginUtils.getnoPerm());
					
				}
				
			}else if(sender instanceof ConsoleCommandSender) {
				
				ConsoleCommandSender p = (ConsoleCommandSender)sender;
				
				if(args.length == 0) {
					
					p.sendMessage(LangUtils.getMessage("system.wrongusage"));
					
				}else if(args.length == 1) {
					
					if(args[0].equalsIgnoreCase("help")) {
						
						p.sendMessage("§7~~~~~~~~~~~~~~~~~~~~");
						p.sendMessage("§6Socialmedia Commands:");
						p.sendMessage(" §8- §7/SocialMedia add <Command>");
						p.sendMessage(" §8- §7/SocialMedia remove <Command>");
						p.sendMessage(" §8- §7/SocialMedia status <Command> <true / false>");
						p.sendMessage(" §8- §7/SocialMedia reload");
						p.sendMessage("§7~~~~~~~~~~~~~~~~~~~~");
						
					}else if(args[0].equalsIgnoreCase("reload") || args[0].equalsIgnoreCase("rl")) {
						
						SocialMediaPlugin.getInstance().reloadConfig();
						
						p.sendMessage(LangUtils.getMessage("system.configreloaded"));
						
					}else {
						
						p.sendMessage(LangUtils.getMessage("system.wrongusage"));
						
					}
					
				}else if(args.length == 2) {
					
					if(args[0].equalsIgnoreCase("add")) {
						
						SocialUtil.addCommand(args[1].toLowerCase());
						
						p.sendMessage(LangUtils.getMessage("system.added"));
						
					}else if(args[0].equalsIgnoreCase("remove")) {
						
						SocialUtil.removeCommand(args[1].toLowerCase());
						
						p.sendMessage(LangUtils.getMessage("system.removed"));
						
					}else {
						
						p.sendMessage(LangUtils.getMessage("system.wrongusage"));
						
					}
					
				}else if(args.length == 3) {
					
					if(args[0].equalsIgnoreCase("status")) {
						
						String Command = args[1].toLowerCase();
						
						if(SocialUtil.getCommands().contains(Command)) {
						
							if(args[2].equalsIgnoreCase("true")) {
								
								SocialUtil.setCommandStatus(Command, true);
								
								p.sendMessage(LangUtils.getMessage("system.activate"));
								
							}else if(args[2].equalsIgnoreCase("false")) {
								
								SocialUtil.setCommandStatus(Command, false);
								
								p.sendMessage(LangUtils.getMessage("system.deactivate"));
								
							}else {
								
								p.sendMessage(LangUtils.getMessage("system.wrongusage"));
								
							}
						
						}else {
							
							p.sendMessage(LangUtils.getMessage("system.existsnot"));
							
						}
						
					}
					
				}else {
					
					p.sendMessage(LangUtils.getMessage("system.wrongusage"));
					
				}
				
			}
			
		}
		
		return false;
	}

}
