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

		if (label.equals("����ä��")) {

			Player player = (Player) sender;

			if (args.length == 0) {
				if (!isConsole) {
					sender.sendMessage(DataManager.getPrefix() + "��b/����ä�� ���� ��f�� �Է����ּ���!");
					return false;
				}
				sender.sendMessage(DataManager.getPrefix() + "��c�ش� ��ɾ�� �ֿܼ��� ���Ұ��� �մϴ�.");
				return false;
			}
			if (args[0].equals("����") || args[0].equalsIgnoreCase("ehdnaakf") || args[0].equalsIgnoreCase("help")) {
				sender.sendMessage("");
				sender.sendMessage("��b--- --- --- --- [ ��f����ä�� ��b] --- --- --- ---");
				sender.sendMessage("");
				sender.sendMessage("��f/����ä�� [��|Ȱ��ȭ|on] ��a: ����ä���� Ȱ��ȭ �մϴ�.");
				sender.sendMessage("��f/����ä�� [����|��Ȱ��ȭ|off] ��a: ����ä���� ��Ȱ��ȭ �մϴ�.");
				if (sender.isOp()) {
					sender.sendMessage("");
					sender.sendMessage("��f/����ä�� ���λ缳�� [���λ�] ��a: ����ä�� �ý����� ���λ縦 �����մϴ�.");
					sender.sendMessage("��f/����ä�� �������� [�Ÿ�] ��a: ����ä�� ������ �����մϴ�.");
					return false;
				}
				sender.sendMessage("");
				sender.sendMessage("��b--- --- --- --- [ ��f����ä�� ��b] --- --- --- ---");
				return false;
			}
			if (args[0].equals("��") || args[0].equals("Ȱ��ȭ") || args[0].equalsIgnoreCase("on")) {
				if (!DataManager.regionchat.contains(player)) {
					DataManager.regionchat.add(player);
					sender.sendMessage(DataManager.getPrefix() + "����ä���� Ȱ��ȭ �Ǿ����ϴ�!");
					return false;
				}
			}
			if (args[0].equals("����") || args[0].equals("��Ȱ��ȭ") || args[0].equalsIgnoreCase("off")) {
				if (DataManager.regionchat.contains(player)) {
					DataManager.regionchat.remove(player);
					sender.sendMessage(DataManager.getPrefix() + "����ä���� ��Ȱ��ȭ �Ǿ����ϴ�!");
					return false;
				}
			}
			if (sender.isOp()) {
				if (args[0].equals("���λ缳��")) {
					if (args.length < 2) {
						sender.sendMessage("��f/����ä�� ���λ缳�� [���λ�] ��a: ����ä�� �ý����� ���λ縦 �����մϴ�.");
						return false;
					}

					DataManager.setPrefix(String.join(" ", args).substring(6));

					sender.sendMessage("��f�Է��Ͻ� ���λ��� �ý������λ縦 �����Ͽ����ϴ�!");
					return false;
				}
				if (args[0].equals("��������")) {
					if (args.length < 2) {
						sender.sendMessage("��f/����ä�� �������� [�Ÿ�] ��a: ����ä�� ������ �����մϴ�.");
						return false;
					}

					if (!args[1].matches("[0-9]+")) {
						sender.sendMessage("��c���ڸ� �����ּ���.");
						return false;
					}

					DataManager.setDistance(Integer.parseInt(args[1]));
					sender.sendMessage("��6�ش� �������� �����Ͽ����ϴ�.");
					return false;
				}
			}
		}
		return false;
	}
}