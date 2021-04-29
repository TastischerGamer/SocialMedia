package me.TastischerGamer.SocialMedia.Utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import me.TastischerGamer.SocialMedia.main.SocialMediaPlugin;

public class ConfigUtil {
		
	private static File folder = SocialMediaPlugin.getInstance().getDataFolder();
	
	public static File langdefile = new File(SocialMediaPlugin.getInstance().getDataFolder() + "/lang_DE.yml");
	
	public static File langenfile = new File(SocialMediaPlugin.getInstance().getDataFolder() + "/lang_EN.yml");
	
	public static File commandfile = new File(SocialMediaPlugin.getInstance().getDataFolder() + "/Commands.yml");
	
	public static File configfile = new File(SocialMediaPlugin.getInstance().getDataFolder() + "/config.yml");
		
	public static void loadConfig() {
		
		if(!folder.exists()) {
			
			folder.mkdir();
			
		}
		
		if(!configfile.exists()) {
			
			try {
				
				configfile.createNewFile();
				
				//loadSConfig();
				
			} catch (IOException e) {
				
				e.printStackTrace();
				
			}
			
			loadSConfig();
			
		}
		
		if(!langdefile.exists()) {

			try {
				
				langdefile.createNewFile();
				
				//loadlangDEConfig();
				
			} catch (IOException e) {
				
				e.printStackTrace();
				
			}
			
			loadlangDEConfig();
			
		}
		
		if(!langenfile.exists()) {

			try {
				
				langenfile.createNewFile();
				
				//loadlangENConfig();
				
			} catch (IOException e) {
				
				e.printStackTrace();
				
			}
			
			loadlangENConfig();
			
		}
		
		if(!commandfile.exists()) {
			
			try {
				
				commandfile.createNewFile();
				
				loadCommandConfig();
				
			} catch (IOException e) {
				
				e.printStackTrace();
				
			}
			
		}
		
	}
	
	public static void loadSConfig() {
		
		FileConfiguration config = YamlConfiguration.loadConfiguration(configfile);
		
		config.set("system.lang", "EN");
		
		config.set("system.permissions.Socialmedia_edit", "social.edit");
		
		try {
			
			config.save(configfile);
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public static void loadlangDEConfig() {
		
		FileConfiguration langdeconfig = YamlConfiguration.loadConfiguration(langdefile);
		
		langdeconfig.set("system.prefix", "&aSocialMedia &8> ");
		langdeconfig.set("system.noPerms", "%prefix%&cDu darfst diesen Command leider nicht ausführen!");
		langdeconfig.set("system.wrongusage", "%prefix%&cBenutze: /SocialMediaManager help");
		langdeconfig.set("system.added", "%prefix%&7Der Command wurde erfolgreich hinzugefügt!");
		langdeconfig.set("system.removed", "%prefix%&7Der Command wurde erfolgreich entfernt!");
		langdeconfig.set("system.exists", "%prefix%&cDer Command existiert bereits!");
		langdeconfig.set("system.existsnot", "%prefix%&cDer Command wurde noch nicht erstellt!");
		langdeconfig.set("system.activate", "%prefix%&cDer Command wurde aktiviert!");
		langdeconfig.set("system.deactivate", "%prefix%&cDer Command wurde deaktiviert!");
		langdeconfig.set("system.deactivated", "%prefix%&cDer Command wurde leider deaktiviert!");
		langdeconfig.set("system.configreloaded", "%prefix%&cDie Config wurde erfolgreich neu geladen!");
		
		try {
			
			langdeconfig.save(langdefile);
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public static void loadlangENConfig() {
		
		FileConfiguration langenconfig = YamlConfiguration.loadConfiguration(langenfile);
		
		langenconfig.set("system.prefix", "&aSocialMedia &8> ");
		langenconfig.set("system.noPerms", "%prefix%&cYou don't have enough Permissions to execute this Command!");
		langenconfig.set("system.wrongusage", "%prefix%&cUse: /SocialMediaManager help");
		langenconfig.set("system.added", "%prefix%&7this Command was successfully added!");
		langenconfig.set("system.removed", "%prefix%&7this Command was successfully removed!");
		langenconfig.set("system.exists", "%prefix%&cthis Command already exists!");
		langenconfig.set("system.existsnot", "%prefix%&cthis Command does not exist!");
		langenconfig.set("system.activate", "%prefix%&cThis Command got activated!");
		langenconfig.set("system.deactivate", "%prefix%&cThis Command got deactivated!");
		langenconfig.set("system.deactivated", "%prefix%&cUnfortunately, this Command got deactivated!");
		langenconfig.set("system.configreloaded", "%prefix%&cThe Config was successfully reloaded");
		
		try {
			
			langenconfig.save(langenfile);
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public static void loadCommandConfig() {
		
		FileConfiguration commandconfig = YamlConfiguration.loadConfiguration(commandfile);
		
		List<String> Commands = SocialUtil.getCommands();
		
		Commands.add("spigotmc");
		
		commandconfig.set("Commands", Commands);
			
		commandconfig.set("spigotmc.message", "&cThis is a Test Command and can be removed with &6/SocialMedia remove spigotmc:\n"
				+ "&aSystem &8> &7Plugin: https://www.spigotmc.org/resources/socialmedia.72490/\n"
				+ "&cDies ist ein Test Command und kann mit &6/SocialMedia remove spigotmc &centfernt werden");
		
		commandconfig.set("spigotmc.status", true);
		
		try {
			
			commandconfig.save(commandfile);
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}

}
