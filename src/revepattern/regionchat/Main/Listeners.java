package revepattern.regionchat.Main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import revepattern.regionchat.Util.DataManager;

public class Listeners implements Listener {

	private static int square(int a) {
		return a * a;
	}

	@EventHandler
	public void chat(AsyncPlayerChatEvent e) {
		final Player player = e.getPlayer();
		if (DataManager.regionChat.contains(player)) {
			e.setCancelled(true);
			for (Player recipient : Bukkit.getOnlinePlayers()) {
				if (player.getLocation().distanceSquared(recipient.getLocation()) <= square(DataManager.getDistance())) {
					recipient.sendMessage("§b[ §f지역채팅§b ] " + player.getDisplayName() + " §7: §a" + e.getMessage());
				}
			}
		}
	}
}
