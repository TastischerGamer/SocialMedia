package me.TastischerGamer.SocialMedia.Listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import me.TastischerGamer.SocialMedia.Utils.LangUtils;
import me.TastischerGamer.SocialMedia.Utils.SocialUtil;

public class CommandListener implements Listener {
	
	@EventHandler
	public void onOwnCommandExecute(PlayerCommandPreprocessEvent e) {
		
		for(String message : SocialUtil.getCommands()) {
			
			if(e.getMessage().toLowerCase().startsWith("/" + message)) {
				
				Player p = e.getPlayer();
				
				if(SocialUtil.getCommandStatus(message) == true) {
					
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', SocialUtil.getCommandMessage(message)));
					
					e.setCancelled(true);
					
				}else {
					
					p.sendMessage(LangUtils.getMessage("system.deactivated"));
					
					e.setCancelled(true);
					
				}
				
			}
			
		}
		
	}

}
