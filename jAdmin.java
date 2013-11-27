package jAdmin;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class jAdmin extends JavaPlugin implements Listener {
	ArrayList<String> Admin = new ArrayList<String>();
	ArrayList<String> Mod = new ArrayList<String>();
    int task = Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
    	public void run() {
    		for(Player players : Bukkit.getOnlinePlayers()) {
    			if(Admin.contains(players.getName())) {
    				for(Player playerss : Bukkit.getOnlinePlayers()) {
    					playerss.hidePlayer(players);
    			        players.showPlayer(players);
    				}
    			}
    		}
    	} 
    }, 20L, 20L);
	//TODO Admin
public void Admin(Player player, String name) {
	if(!(Admin.contains(name))) {
	for(Player players : Bukkit.getOnlinePlayers()) {
		players.hidePlayer(player);
	}
	player.sendMessage(ChatColor.RED + "You are now vanished from all players. No one will know you are online.");
	Admin.add(name);
	} else {
		for(Player players : Bukkit.getOnlinePlayers()) {
			players.showPlayer(player);
		}
		player.sendMessage(ChatColor.RED + "You are now visible to all players. Everyone may see you again.");
		Admin.remove(name);
	}
}
//TODO Mod
public void Mod(Player player, String name) {
	
}

public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
	if(cmd.getName().equalsIgnoreCase("admin")) {
		Player p = (Player) sender;
		if(p.hasPermission("jAdmin.a") || p.getName().equals("MayoDwarf")) { //I need to be able to do this command. I like it. - MayoDwarf
			Admin(p, p.getName());
		}
	}
	
	if(cmd.getName().equalsIgnoreCase("mod")) {
		Player p = (Player) sender;
		if(p.hasPermission("jAdmin.m")) {
			Mod(p, p.getName());
		}
	}
	return true;
	
}
}
//Whoever is reading this, a girl who was really hot and is a freshman checked me out today. Saw her 2 times and she was always looking at me. Hopefully see her again monday! :) - Nov. 1, 2013
