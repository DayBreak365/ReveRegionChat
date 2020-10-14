package revepattern.regionchat.Util;

import java.util.ArrayList;
import org.bukkit.entity.Player;
import revepattern.regionchat.Main.Main;

public class DataManager {

	public static ArrayList<Player> regionchat;
	//public static Object regionchat;
	
	static {
		regionchat = new ArrayList<Player>();
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
