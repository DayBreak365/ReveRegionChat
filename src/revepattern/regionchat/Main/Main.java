package revepattern.regionchat.Main;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import revepattern.regionchat.Commands.Commands;

public class Main extends JavaPlugin {
	
	public static Main instance;
	public static FileConfiguration cf;
	
	public void onEnable() {
		
		instance = this;
		
		saveDefaultConfig();
		cf = getConfig();
		
		getCommand("지역채팅").setExecutor(new Commands());
		
		Bukkit.getPluginManager().registerEvents(new Listeners(), this);
		Bukkit.getConsoleSender().sendMessage("§b레브 지역채팅 플러그인이 로딩되었습니다! - 제작자 : RevePattern(레브패턴)");
	}
	
	public void onDisable() {
		
		Bukkit.getConsoleSender().sendMessage("§b레브 지역채팅 플러그인이 종료되었습니다! - 제작자 : RevePattern(레브패턴)");
	}

}
