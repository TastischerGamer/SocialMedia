package me.TastischerGamer.SocialMedia.Utils;

import java.io.File;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import me.TastischerGamer.SocialMedia.main.SocialMediaPlugin;

public class LangUtils {
	
	public static String Version_Message_not_work_DE = "Dieses Plugin funktioniert auf dieser Minecraft Version nicht!";
	public static String Version_Message_not_work_EN = "This Plugin doesn't work on this Minecraft Version!";
	public static String Version_Message_not_checked_DE = "Dieses Plugin wurde nicht auf dieser Minecraft Version getestet!";
	public static String Version_Message_not_checked_EN = "This plugin has not been tested on this Minecraft version!";
	public static String Version_Message_1_8_0_DE = "Es wird aus Sicherheitsgründen Empfohlen auf die Minecraft Version 1.8.8 zu aktualisieren!";
	public static String Version_Message_1_8_0_EN = "It is recommended to update to Minecraft version 1.8.8 for security reasons!";
	
	public static String getLang() {
		
		String Lang = SocialMediaPlugin.getInstance().getConfig().getString("system.lang");
		
		return Lang;
		
	}
	
	public static String getMessage(String Path) {
		
		File file = new File(SocialMediaPlugin.getInstance().getDataFolder() + "/lang_" + getLang() + ".yml");
		
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		
		String Content = "";
		
		if(Path != "system.prefix") {
		
			Content = ChatColor.translateAlternateColorCodes('&', config.getString(Path).replace("%prefix%", PluginUtils.getPrefix()));
		
		}else {
			
			Content = config.getString(Path);
			
		}
		
		return Content;
		
	}
	
	public static String getVersionMessage(String message) {
				
		if(message.equals("not_work")) {
			
			if(getLang().equals("DE")) {
				
				return Version_Message_not_work_DE;
				
			}else if(getLang().equals("EN")) {
				
				return Version_Message_not_work_EN;
				
			}else {
				
				return Version_Message_not_work_EN;
				
			}
			
		}
		
		if(message.equals("not_checked")) {
					
			if(getLang().equals("DE")) {
				
				return Version_Message_not_checked_DE;
				
			}else if(getLang().equals("EN")) {
				
				return Version_Message_not_checked_EN;
				
			}else {
				
				return Version_Message_not_checked_EN;
				
			}
					
		}
		
		if(message.equals("1.8.0")) {
			
			if(getLang().equals("DE")) {
				
				return Version_Message_1_8_0_DE;
				
			}else if(getLang().equals("EN")) {
				
				return Version_Message_1_8_0_EN;
				
			}else {
				
				return Version_Message_1_8_0_EN;
				
			}
			
		}
		
		return "";
		
	}

}
