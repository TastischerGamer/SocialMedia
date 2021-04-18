package me.TastischerGamer.SocialMedia.main;

import org.bukkit.plugin.java.JavaPlugin;

import me.TastischerGamer.SocialMedia.commands.*;

public class Main extends JavaPlugin {
	
	public static Main plugin;
	
	public void onEnable() {
		
		Main.plugin = this;
		onConfigLoad();
		
		this.getCommand("teamspeak").setExecutor(new TeamspeakCommand());
		this.getCommand("discord").setExecutor(new DiscordCommand());
		this.getCommand("facebook").setExecutor(new FacebookCommand());
		this.getCommand("twitch").setExecutor(new TwitchCommand());
		this.getCommand("twitter").setExecutor(new TwitterCommand());
		this.getCommand("website").setExecutor(new WebsiteCommand());
		this.getCommand("youtube").setExecutor(new YoutubeCommand());
		this.getCommand("socialconfig").setExecutor(new socialconfig());
		
	}
	
	public void onDisable() {
		
		
		
	}
	
	public void onConfigLoad() {
		
		getConfig().options().copyDefaults(true);
		
		getConfig().addDefault("system.prefix", "&a&lSocialMedia &8| ");
		getConfig().addDefault("system.noPerms", "&c&lSorry but you don´t have enough Permissions!");
		getConfig().addDefault("system.deactivatedmessage", "&c&lSorry but this Command doesn´t exists!");
		getConfig().addDefault("system.configrl", "&a&lConfig Reloaded!");
		
		
		getConfig().addDefault("server.ts", "&a&lOur Teamspeak Server: %link%");
		getConfig().addDefault("server.discord", "&a&lOur Discord Server: %link%");
		getConfig().addDefault("server.facebook", "&a&lOur Facebook Account: %link%");
		getConfig().addDefault("server.twitch", "&a&lOur Twitch Channel: %link%");
		getConfig().addDefault("server.twitter", "&a&lOur Twitter Account: %link%");
		getConfig().addDefault("server.website", "&a&lOur Website: %link%");
		getConfig().addDefault("server.yt", "&a&lOur Youtube Channel: %link%");
		
		
		getConfig().addDefault("link.teamspeak", "[TEAMSPEAK LINK]");
		getConfig().addDefault("link.discord", "[DISCORD LINK]");
		getConfig().addDefault("link.facebook", "[FACEBOOK LINK]");
		getConfig().addDefault("link.twitch", "[TWITCH LINK]");
		getConfig().addDefault("link.twitter", "[TWITTER LINK]");
		getConfig().addDefault("link.website", "[WEBSITE LINK]");
		getConfig().addDefault("link.yt", "[YOUTUBE LINK]");
		
		
		getConfig().addDefault("ts.activated", "false");
		getConfig().addDefault("discord.activated", "false");
		getConfig().addDefault("facebook.activated", "false");
		getConfig().addDefault("twitch.activated", "false");
		getConfig().addDefault("twitter.activated", "false");
		getConfig().addDefault("website.activated", "false");
		getConfig().addDefault("yt.activated", "false");
		
		saveConfig();
		saveDefaultConfig();
		
	}
	
	public static Main getPlugin() {
		
		return Main.plugin;
		
	}

}
