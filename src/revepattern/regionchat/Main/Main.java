package revepattern.regionchat.Main;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import revepattern.regionchat.Commands.Commands;

public class Main extends JavaPlugin {
	
	public static Main instance;
	public static FileConfiguration cf;

	public Main() {
		instance = this;
	}

	public void onEnable() {
		saveDefaultConfig();
		cf = getConfig();
		setCommandExecutors();
		registerListeners();
		Bukkit.getConsoleSender().sendMessage("§b레브 지역채팅 플러그인이 로딩되었습니다! - 제작자 : RevePattern(레브패턴)");
	}
	
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage("§b레브 지역채팅 플러그인이 종료되었습니다! - 제작자 : RevePattern(레브패턴)");
	}
	
	private void setCommandExecutors() {
		for (String cmd : new String[]{"지역채팅", "지역채팅관리"}) {
			getCommand(cmd).setExecutor(new Commands());
		}
	}

	private void registerListeners() {
		Bukkit.getPluginManager().registerEvents(new Listeners(), this);
	}

}
