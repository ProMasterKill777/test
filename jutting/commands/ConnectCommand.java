package jutting.commands;

import java.net.InetSocketAddress;
import jutting.BungeeHack;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class ConnectCommand extends Command {
   public ConnectCommand() {
      super("connect");
   }

   public void execute(CommandSender sender, String[] args) {
      if (sender instanceof ProxiedPlayer) {
         ProxiedPlayer proxiedPlayer = (ProxiedPlayer)sender;
         if (args.length != 0 && args.length <= 1) {
            if (args.length == 1) {
               String var10003;
               String host;
               if (args[0].contains(":")) {
                  host = args[0].split(":")[0];
                  int port = Integer.valueOf(args[0].split(":")[1]);
                  proxiedPlayer.connect(ProxyServer.getInstance().constructServerInfo("tempserver", new InetSocketAddress(host, port), "Temp-MOTD", false));
                  var10003 = BungeeHack.getPrefix();
                  proxiedPlayer.sendMessage(new TextComponent(var10003 + "Connecting to §e" + args[0]));
               } else {
                  host = args[0];
                  int port = 25565;
                  proxiedPlayer.connect(ProxyServer.getInstance().constructServerInfo("tempserver", new InetSocketAddress(host, port), "Temp-MOTD", false));
                  var10003 = BungeeHack.getPrefix();
                  proxiedPlayer.sendMessage(new TextComponent(var10003 + "Connecting to §e" + args[0]));
               }
            }
         } else {
            proxiedPlayer.sendMessage(new TextComponent(BungeeHack.getPrefix() + "§a/connect <ip>"));
         }
      } else {
         sender.sendMessage(new TextComponent("§aYou can't use this command in console!"));
      }

   }
}
