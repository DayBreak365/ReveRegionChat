package revepattern.regionchat.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import revepattern.regionchat.Util.DataManager;

public class Commands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		boolean isConsole = sender instanceof ConsoleCommandSender;
		
		if (label.equals("지역채팅")) {
			
			if (isConsole) {
				sendMessage(sender, "§c콘솔로는 명령어를 사용할 수 없습니다!");
				return false;
			}
			Player player = (Player) sender;
			if (DataManager.regionchat.contains(player)) {
				DataManager.regionchat.remove(player);
				sendMessage(sender, "§f지역채팅을 비활성화 했습니다.");
				return false;
			}
			DataManager.regionchat.add(player);
			sendMessage(sender, "§f지역채팅을 활성화 했습니다.");
			return false;
		}
		if (label.equals("지역채팅관리")) {
			if (isConsole) {
				sendMessage(sender, "§c콘솔로는 명령어를 사용할 수 없습니다.");
				return false;
			}
			Player player = (Player) sender;
			
			if (!player.isOp()) {
				sendMessage(sender, "§c관리명령어 사용불가능!");
			}
			
			if (args.length == 0) {
				sendMessage(sender, "§b--- --- --- --- §f지역채팅관리 명령어 도움말 §b--- --- --- --- ");
				sendMessage(sender, "§f/지역채팅 접두사설정 [접두사] §a: 지역채팅 시스템의 접두사를 설정합니다.");
				sendMessage(sender, "§f/지역채팅 범위설정 [거리] §a: 지역채팅 범위를 설정합니다.");
				sendMessage(sender, "§b--- --- --- --- §f지역채팅관리 명령어 도움말 §b--- --- --- --- ");
				return false;
			}
			if (args[0].equals("접두사설정")) {
				if (args.length < 2) {
					sendMessage(sender, "§f/지역채팅 접두사설정 [접두사] §a: 지역채팅 시스템의 접두사를 설정합니다.");
					return false;
				}
				DataManager.setPrefix(String.join(" ", args).substring(6));
				sendMessage(sender, "§f시스템 접두사를" + DataManager.getPrefix() + "§f 로 설정하였습니다!");
				return false;
			}
			if (args[0].equals("범위설정")) {
				if (args.length < 2) {
					sendMessage(sender, "§f/지역채팅 범위설정 [거리] §a: 지역채팅 범위를 설정합니다.");
					return false;
				}
				if (!args[1].matches("[0-9]+")) {
					sendMessage(sender, "§c숫자만 적어주세요!");
					return false;
				}
				DataManager.setDistance(Integer.parseInt(args[1]));
				sendMessage(sender, "§f해당 범위로 설정하였습니다. (§b범위:" + DataManager.getDistance() + "§f)");
				return false;
			}
		}
		return false;
	}
	
	public static void sendMessage(CommandSender sender, String msg) {
		sender.sendMessage( DataManager.getPrefix() + msg);
	}
}
