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
		
		getCommand("����ä��").setExecutor(new Commands());
		
		Bukkit.getPluginManager().registerEvents(new Listeners(), this);
		Bukkit.getConsoleSender().sendMessage("��b���� ����ä�� �÷������� �ε��Ǿ����ϴ�! - ������ : RevePattern(��������)");
	}
	
	public void onDisable() {
		
		Bukkit.getConsoleSender().sendMessage("��b���� ����ä�� �÷������� ����Ǿ����ϴ�! - ������ : RevePattern(��������)");
	}

}
