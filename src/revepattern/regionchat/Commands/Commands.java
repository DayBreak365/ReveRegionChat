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

			Player player = (Player) sender;

			if (args.length == 0) {
				if (!isConsole) {
					sender.sendMessage(DataManager.getPrefix() + "§b/지역채팅 도움말 §f을 입력해주세요!");
					return false;
				}
				sender.sendMessage(DataManager.getPrefix() + "§c해당 명령어는 콘솔에서 사용불가능 합니다.");
				return false;
			}
			if (args[0].equals("도움말") || args[0].equalsIgnoreCase("ehdnaakf") || args[0].equalsIgnoreCase("help")) {
				sender.sendMessage("");
				sender.sendMessage("§b--- --- --- --- [ §f지역채팅 §b] --- --- --- ---");
				sender.sendMessage("");
				sender.sendMessage("§f/지역채팅 [온|활성화|on] §a: 지역채팅을 활성화 합니다.");
				sender.sendMessage("§f/지역채팅 [오프|비활성화|off] §a: 지역채팅을 비활성화 합니다.");
				if (sender.isOp()) {
					sender.sendMessage("");
					sender.sendMessage("§f/지역채팅 접두사설정 [접두사] §a: 지역채팅 시스템의 접두사를 설정합니다.");
					sender.sendMessage("§f/지역채팅 범위설정 [거리] §a: 지역채팅 범위를 설정합니다.");
					return false;
				}
				sender.sendMessage("");
				sender.sendMessage("§b--- --- --- --- [ §f지역채팅 §b] --- --- --- ---");
				return false;
			}
			if (args[0].equals("온") || args[0].equals("활성화") || args[0].equalsIgnoreCase("on")) {
				if (!DataManager.regionchat.contains(player)) {
					DataManager.regionchat.add(player);
					sender.sendMessage(DataManager.getPrefix() + "지역채팅이 활성화 되었습니다!");
					return false;
				}
			}
			if (args[0].equals("오프") || args[0].equals("비활성화") || args[0].equalsIgnoreCase("off")) {
				if (DataManager.regionchat.contains(player)) {
					DataManager.regionchat.remove(player);
					sender.sendMessage(DataManager.getPrefix() + "지역채팅이 비활성화 되었습니다!");
					return false;
				}
			}
			if (sender.isOp()) {
				if (args[0].equals("접두사설정")) {
					if (args.length < 2) {
						sender.sendMessage("§f/지역채팅 접두사설정 [접두사] §a: 지역채팅 시스템의 접두사를 설정합니다.");
						return false;
					}

					DataManager.setPrefix(String.join(" ", args).substring(6));

					sender.sendMessage("§f입력하신 접두사대로 시스템접두사를 설정하였습니다!");
					return false;
				}
				if (args[0].equals("범위설정")) {
					if (args.length < 2) {
						sender.sendMessage("§f/지역채팅 범위설정 [거리] §a: 지역채팅 범위를 설정합니다.");
						return false;
					}

					if (!args[1].matches("[0-9]+")) {
						sender.sendMessage("§c숫자만 적어주세요.");
						return false;
					}

					DataManager.setDistance(Integer.parseInt(args[1]));
					sender.sendMessage("§6해당 범위으로 설정하였습니다.");
					return false;
				}
			}
		}
		return false;
	}
}