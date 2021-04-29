package me.TastischerGamer.SocialMedia.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.TastischerGamer.SocialMedia.Listener.CommandListener;
import me.TastischerGamer.SocialMedia.Utils.ConfigUtil;
import me.TastischerGamer.SocialMedia.Utils.PluginUtils;
import me.TastischerGamer.SocialMedia.commands.SocialMediaManager;

public class SocialMediaPlugin extends JavaPlugin {
	
	private static SocialMediaPlugin instance;
	
	public void onEnable() {
		
		SocialMediaPlugin.instance = this;
		
		ConfigUtil.loadConfig();
		
		Bukkit.getConsoleSender().sendMessage("§7~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		Bukkit.getConsoleSender().sendMessage("§6SocialMedia Plugin:");
		Bukkit.getConsoleSender().sendMessage(" §8- §7Author: §6TastischerGamer");
		Bukkit.getConsoleSender().sendMessage(" §8- §7Plugin Version: §6" + this.getDescription().getVersion());
		Bukkit.getConsoleSender().sendMessage(" §8- §7Server Version: §a" + PluginUtils.checkServerVersion());
		Bukkit.getConsoleSender().sendMessage(" §8- §7SpigotMC: §6https://www.spigotmc.org/resources/socialmedia.72490/");
		Bukkit.getConsoleSender().sendMessage(" §8- §7GitHub: §6https://github.com/TastischerGamer/SocialMedia");
		Bukkit.getConsoleSender().sendMessage("§7~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		PluginManager pm = Bukkit.getPluginManager();
		
		pm.registerEvents(new CommandListener(), this);
		
		this.getCommand("SocialMediaManager").setExecutor(new SocialMediaManager());
		
	}
	
	public void onDisable() {
		
		
		
	}
	
	public static SocialMediaPlugin getInstance() {
		
		return SocialMediaPlugin.instance;
		
	}

}
