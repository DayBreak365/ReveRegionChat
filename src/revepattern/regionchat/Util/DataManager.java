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
		Main.cf.set("시스템 접두사", prefix);
		Main.instance.saveConfig();
	}

	public static String getPrefix() {
		return Main.cf.getString("시스템 접두사", "접두사가 설정이 안되있어요!");
	}

	public static void setDistance(int distance) {
		Main.cf.set("지역채팅 거리", distance);
		Main.instance.saveConfig();
	}

	public static int getDistance() {
		return Main.cf.getInt("지역채팅 거리");
	}

}
