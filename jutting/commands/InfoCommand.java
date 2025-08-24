package jutting.commands;

import jutting.BungeeHack;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class InfoCommand extends Command {
   public InfoCommand() {
      super("info");
   }

   public void execute(CommandSender sender, String[] args) {
      ProxiedPlayer player = (ProxiedPlayer)sender;
      String var10001 = String.valueOf(ChatColor.GREEN);
      sender.sendMessage(var10001 + "Name: " + player.getName());
      var10001 = String.valueOf(ChatColor.GREEN);
      sender.sendMessage(var10001 + "UUID: " + String.valueOf(player.getUniqueId()));
      var10001 = String.valueOf(ChatColor.GREEN);
      sender.sendMessage(var10001 + "IP: " + BungeeHack.getIP());
   }
}
