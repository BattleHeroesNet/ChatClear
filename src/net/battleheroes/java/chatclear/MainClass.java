package net.battleheroes.java.chatclear;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class MainClass extends JavaPlugin implements Chat{
    public void onEnable() {
        Bukkit.getServer().getLogger().info(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("Prefix")) +
        		ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("OnStart")));
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();
    }

    public void onDisable() {
        Bukkit.getServer().getLogger().info(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("Prefix")) +
        		ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("OnStop")));
    }
   
	public boolean onCommand(CommandSender sender, Command Cmd, String commandLabel, String[] args) {
        if (Cmd.getName().equalsIgnoreCase("cc")){
        	
        	String name = sender.getName();
        	
            int a = 0;
            int howMuch = this.getConfig().getInt("LineClear");
            
            while(a < howMuch) {
            	
            	for (Player player : Bukkit.getOnlinePlayers()) {
            	    player.sendMessage(" ");
            	    
            	}
            	a++;
            }
            
            Bukkit.broadcastMessage(gray + strike + "-------------------------------------------------");
            Bukkit.broadcastMessage(" ");
            Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("Prefix")) +
            		" " + ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GlobalClear")) + " " + red + bold + name + gray + ".");
            Bukkit.broadcastMessage(" ");
            Bukkit.broadcastMessage(gray + strike + "-------------------------------------------------");
        	
        }
        
        if (Cmd.getName().equalsIgnoreCase("cmc")){
        	
        	Player p = (Player) sender;
        	
        	
            int a = 0;
            int howMuch = this.getConfig().getInt("LineClear");
            p.sendMessage(howMuch + "sdas");
            while(a < howMuch) {
            	p.sendMessage(" ");
            	a++;
            }
            
            p.sendMessage(gray + strike + "-------------------------------------------------");
            p.sendMessage(" ");
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("Prefix")) +
            		" " + ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("SelfClear")));
            p.sendMessage(" ");
            p.sendMessage(gray + strike + "-------------------------------------------------");
        	
        }
        
        Player p = (Player) sender;
        
        if (Cmd.getName().equalsIgnoreCase("cco")) {
        	
			Player t = Bukkit.getServer().getPlayer(args[0]);
			if (t == null) {
				p.sendMessage(ChatColor.RED + "Player not found!");
			
			}
			
			int a = 0;
            int howMuch = this.getConfig().getInt("LineClear");
            
            while(a < howMuch) {
            	t.sendMessage(" ");
            	a++;
            	
            	
            }	
            
            t.sendMessage(gray + strike + "-------------------------------------------------");
            t.sendMessage(" ");
            t.sendMessage(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("Prefix")) +
        			" " + ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("OtherClearedMyChat")));
            t.sendMessage(" ");
            t.sendMessage(gray + strike + "-------------------------------------------------");
            
            p.sendMessage(gray + strike + "-------------------------------------------------");
            p.sendMessage(" ");
			p.sendMessage(ChatColor.translateAlternateColorCodes('&',this.getConfig().getString("Prefix"))
					+ " " + ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("ClearedOther")));
            p.sendMessage(" ");
            p.sendMessage(gray + strike + "-------------------------------------------------");
			return true;
		}
        
        
        return true;
	}
}