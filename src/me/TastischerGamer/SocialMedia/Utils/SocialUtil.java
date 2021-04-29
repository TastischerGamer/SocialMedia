package me.TastischerGamer.SocialMedia.Utils;

import java.io.IOException;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class SocialUtil {
	
	public static List<String> getCommands() {
		
		FileConfiguration commandconfig = YamlConfiguration.loadConfiguration(ConfigUtil.commandfile);
		
		List<String> Commands = commandconfig.getStringList("Commands");
		
		return Commands;
		
	}
	
	public static void addCommand(Player executor, String Command) {
		
		List<String> Commands = getCommands();
		FileConfiguration commandconfig = YamlConfiguration.loadConfiguration(ConfigUtil.commandfile);
		
		if(!Commands.contains(Command.toLowerCase())) {
			
			Commands.add(Command.toLowerCase());
			
			if(LangUtils.getLang().equals("DE")) {
			
				commandconfig.set(Command + ".message", "&cTest Nachricht!");
			
			}else {
				
				commandconfig.set(Command + ".message", "&cTest Message!");
				
			}
			
			commandconfig.set("Commands", Commands);
			commandconfig.set(Command + ".status", false);
			
			try {
				
				commandconfig.save(ConfigUtil.commandfile);
				
			} catch (IOException e) {
				
				e.printStackTrace();
				
			}
			
			executor.sendMessage(LangUtils.getMessage("system.added"));
			
		}else {
			
			executor.sendMessage(LangUtils.getMessage("system.exists"));
			
		}
		
	}
	
	public static void removeCommand(Player executor, String Command) {
		
		List<String> Commands = getCommands();
		FileConfiguration commandconfig = YamlConfiguration.loadConfiguration(ConfigUtil.commandfile);
		
		if(Commands.contains(Command.toLowerCase())) {
			
			Commands.remove(Command.toLowerCase());
			
			executor.sendMessage(LangUtils.getMessage("system.removed"));
						
			commandconfig.set(Command, null);
			commandconfig.set("Commands", Commands);
			
			try {
				
				commandconfig.save(ConfigUtil.commandfile);
				
			} catch (IOException e) {
				
				e.printStackTrace();
				
			}
			
		}else {
			
			executor.sendMessage(LangUtils.getMessage("system.existsnot"));
			
		}
		
	}
	
	public static void addCommand(String Command) {
		
		List<String> Commands = getCommands();
		FileConfiguration commandconfig = YamlConfiguration.loadConfiguration(ConfigUtil.commandfile);
		
		if(!Commands.contains(Command.toLowerCase())) {
			
			Commands.add(Command.toLowerCase());
			
			if(LangUtils.getLang().equals("DE")) {
			
				commandconfig.set(Command + ".message", "&cTest Nachricht!");
			
			}else {
				
				commandconfig.set(Command + ".message", "&cTest Message!");
				
			}
			
			commandconfig.set("Commands", Commands);
			commandconfig.set(Command + ".status", false);
			
			try {
				
				commandconfig.save(ConfigUtil.commandfile);
				
			} catch (IOException e) {
				
				e.printStackTrace();
				
			}
						
		}
		
	}
	
	public static void removeCommand(String Command) {
		
		List<String> Commands = getCommands();
		FileConfiguration commandconfig = YamlConfiguration.loadConfiguration(ConfigUtil.commandfile);
		
		if(Commands.contains(Command.toLowerCase())) {
			
			Commands.remove(Command.toLowerCase());
									
			commandconfig.set(Command, null);
			commandconfig.set("Commands", Commands);
			
			try {
				
				commandconfig.save(ConfigUtil.commandfile);
				
			} catch (IOException e) {
				
				e.printStackTrace();
				
			}
			
		}
		
	}
	
	public static void setCommandMessage(String Command, String Message) {
		
		FileConfiguration commandconfig = YamlConfiguration.loadConfiguration(ConfigUtil.commandfile);

		commandconfig.set(Command + ".message", Message);
		
		try {
			
			commandconfig.save(ConfigUtil.commandfile);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static void setCommandStatus(Player executor, String Command, boolean Status) {
		
		FileConfiguration commandconfig = YamlConfiguration.loadConfiguration(ConfigUtil.commandfile);

		commandconfig.set(Command + ".status", Status);
		
		try {
			
			commandconfig.save(ConfigUtil.commandfile);
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public static void setCommandStatus(String Command, boolean Status) {
		
		FileConfiguration commandconfig = YamlConfiguration.loadConfiguration(ConfigUtil.commandfile);

		commandconfig.set(Command + ".status", Status);
		
		try {
			
			commandconfig.save(ConfigUtil.commandfile);
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public static boolean getCommandStatus(String Command) {
		
		FileConfiguration commandconfig = YamlConfiguration.loadConfiguration(ConfigUtil.commandfile);

		boolean Status = commandconfig.getBoolean(Command + ".status");
		
		return Status;	
		
	}
	
	public static String getCommandMessage(String Command) {
		
		FileConfiguration commandconfig = YamlConfiguration.loadConfiguration(ConfigUtil.commandfile);
		
		String Message = commandconfig.getString(Command + ".message").replace("%prefix%", PluginUtils.getPrefix());
		
		return Message;
		
	}

}
