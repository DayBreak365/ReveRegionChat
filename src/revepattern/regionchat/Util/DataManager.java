package revepattern.regionchat.Util;

import org.bukkit.entity.Player;
import revepattern.regionchat.Main.Main;

import java.util.HashSet;
import java.util.Set;

public class DataManager {

	public static Set<Player> regionChat;
	
	static {
		regionChat = new HashSet<>();
	}

	public static void setPrefix(String prefix) {
		Main.cf.set("�ý��� ���λ�", prefix);
		Main.instance.saveConfig();
	}

	public static String getPrefix() {
		return Main.cf.getString("�ý��� ���λ�", "���λ簡 ������ �ȵ��־��!");
	}

	public static void setDistance(int distance) {
		Main.cf.set("����ä�� �Ÿ�", distance);
		Main.instance.saveConfig();
	}

	public static int getDistance() {
		return Main.cf.getInt("����ä�� �Ÿ�");
	}

}
