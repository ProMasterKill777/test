package jutting.commands;

import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.UUID;
import jutting.BungeeHack;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class UUIDCommand extends Command {
   public UUIDCommand() {
      super("uuid");
   }

   public void execute(CommandSender sender, String[] args) {
      if (args.length != 0 && args.length <= 1) {
         if (args.length == 1) {
            try {
               BungeeHack.setUUID(fetchUUID(args[0]));
               String var10001 = String.valueOf(ChatColor.GREEN);
               sender.sendMessage(var10001 + "UUID set to " + String.valueOf(fetchUUID(args[0])) + "!");
            } catch (Exception var4) {
               var4.printStackTrace();
            }
         }
      } else {
         sender.sendMessage(new TextComponent(BungeeHack.getPrefix() + "§a/uuid <UUID>"));
      }

   }

   public static UUID fetchUUID(String s) throws Exception {
      URL url = new URL("https://api.mojang.com/users/profiles/minecraft/" + s);
      String uuid = (String)((JSONObject)(new JSONParser()).parse((Reader)(new InputStreamReader(url.openStream())))).get("id");
      String var10000 = uuid.substring(0, 8);
      String realUUID = var10000 + "-" + uuid.substring(8, 12) + "-" + uuid.substring(12, 16) + "-" + uuid.substring(16, 20) + "-" + uuid.substring(20, 32);
      return UUID.fromString(realUUID);
   }
}
