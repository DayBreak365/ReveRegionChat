package revepattern.regionchat.Main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import revepattern.regionchat.Util.DataManager;

public class Listeners implements Listener {

	@EventHandler
	public void chat(AsyncPlayerChatEvent e) {
		Player player = e.getPlayer();
		if (DataManager.regionchat.contains(player)) {
			e.setCancelled(true);
			int distance = DataManager.getDistance();
			for (Player rgplayer : Bukkit.getOnlinePlayers()) {
				int a = (int) player.getLocation().distance(rgplayer.getLocation());
				if (a <= distance) {
					rgplayer.sendMessage("§b[ §f지역채팅§b ] " + player.getDisplayName() + " §7: §a" + e.getMessage());
				}
			}
		}
	}
}
