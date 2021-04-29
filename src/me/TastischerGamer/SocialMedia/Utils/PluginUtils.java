package me.TastischerGamer.SocialMedia.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import me.TastischerGamer.SocialMedia.main.SocialMediaPlugin;

public class PluginUtils {
	
	public static String getPrefix() {
		
		String Prefix = LangUtils.getMessage("system.prefix");
		
		return Prefix;
		
	}
	
	public static String getnoPerm() {
		
		String noPerm = ChatColor.translateAlternateColorCodes('&', LangUtils.getMessage("system.noPerms"));
		
		return noPerm;
		
	}
	
	public static String getPermission(String Command) {
		
		String Perm = SocialMediaPlugin.getInstance().getConfig().getString("system.permissions." + Command);
		
		return Perm;
		
	}
	
	public static String checkServerVersion() {
		
		if(Bukkit.getBukkitVersion().equals("1.8-R0.1-SNAPSHOT")) {
			
			String Output = "§c" + Bukkit.getBukkitVersion() + "\n §4-> "  + LangUtils.getVersionMessage("1.8.0");
			return Output;
			
		}
		
		if(Bukkit.getBukkitVersion().equals("1.8.3-R0.1-SNAPSHOT")) {
			
			String Output = "§c" + Bukkit.getBukkitVersion() + "\n §4-> "  + LangUtils.getVersionMessage("1.8.0");
			return Output;
			
		}
		
		if(Bukkit.getBukkitVersion().equals("1.8.4-R0.1-SNAPSHOT")) {
			
			String Output = "§c" + Bukkit.getBukkitVersion() + "\n §4-> "  + LangUtils.getVersionMessage("1.8.0");
			return Output;
			
		}
		
		if(Bukkit.getBukkitVersion().equals("1.8.5-R0.1-SNAPSHOT")) {
			
			String Output = "§c" + Bukkit.getBukkitVersion() + "\n §4-> "  + LangUtils.getVersionMessage("1.8.0");
			return Output;
			
		}
		
		if(Bukkit.getBukkitVersion().equals("1.8.6-R0.1-SNAPSHOT")) {
			
			String Output = "§c" + Bukkit.getBukkitVersion() + "\n §4-> "  + LangUtils.getVersionMessage("1.8.0");
			return Output;
			
		}
		
		if(Bukkit.getBukkitVersion().equals("1.8.7-R0.1-SNAPSHOT")) {
			
			String Output = "§c" + Bukkit.getBukkitVersion() + "\n §4-> "  + LangUtils.getVersionMessage("1.8.0");
			return Output;
			
		}
		
		if(Bukkit.getBukkitVersion().equals("1.8.8-R0.1-SNAPSHOT")) {
			
			String Output = "§a" + Bukkit.getBukkitVersion();
			return Output;
			
		}
		
		if(Bukkit.getBukkitVersion().startsWith("1.9.")) {
			
			String Output = "§a" + Bukkit.getBukkitVersion();
			return Output;
			
		}
		
		if(Bukkit.getBukkitVersion().startsWith("1.10.")) {
			
			String Output = "§a" + Bukkit.getBukkitVersion();
			return Output;
			
		}
		
		if(Bukkit.getBukkitVersion().startsWith("1.12.")) {
			
			String Output = "§a" + Bukkit.getBukkitVersion();
			return Output;
			
		}
		
		if(Bukkit.getBukkitVersion().startsWith("1.14.")) {
			
			String Output = "§a" + Bukkit.getBukkitVersion();
			return Output;
			
		}
		
		if(Bukkit.getBukkitVersion().startsWith("1.16.")) {
			
			String Output = "§a" + Bukkit.getBukkitVersion();
			return Output;
			
		}
		
		return "§c" + Bukkit.getBukkitVersion() + "\n §4-> " + LangUtils.getVersionMessage("not_checked");
		
	}

}
