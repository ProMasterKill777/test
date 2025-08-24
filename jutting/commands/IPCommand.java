package jutting.commands;

import jutting.BungeeHack;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;

public class IPCommand extends Command {
   public IPCommand() {
      super("setip");
   }

   public void execute(CommandSender sender, String[] args) {
      if (args.length != 0 && args.length <= 1) {
         if (args.length == 1) {
            BungeeHack.setIP(args[0]);
            String var10003 = BungeeHack.getPrefix();
            sender.sendMessage(new TextComponent(var10003 + "IP set to §a" + args[0] + "§a!"));
         }
      } else {
         sender.sendMessage(new TextComponent(BungeeHack.getPrefix() + "§a/setip <ip>"));
      }

   }
}
