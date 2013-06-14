package io.github.James221.NoDrop;



import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.plugin.java.JavaPlugin;



	public final class NoDrop extends JavaPlugin implements Listener {
		public void onEnable(){
			getLogger().info("onEnable has been invoked!");
			getServer().getPluginManager().registerEvents(this, this);
			getConfig().options().copyDefaults(true);
			this.saveConfig();
		}
		public void onDisable(){
			getLogger().info("onDisable has been invoked!");
		}			
		public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
			Player player = (Player) sender;
			if(cmd.getName().equalsIgnoreCase("NoDrop")){
				player.sendMessage(getConfig().getString("NoDrop"));
				return true;
			}
			return false; 
		}
	
		
		
	@EventHandler
    public void onDrop(PlayerDropItemEvent event) {
    	Player player = event.getPlayer();
    	event.setCancelled(true);
    	player.sendMessage(getConfig().getString("Drop"));
    	int integerValue = getConfig().getInt("Kill");
    	player.damage(integerValue);
    	}
    	
//////CODE MADE BY AWESOMEJAMES221\\\\\\
}
